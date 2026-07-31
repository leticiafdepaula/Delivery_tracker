package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.dto.request.CriarPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import br.com.fooddelivery.delivery_tracker.exception.RecursoNaoEncontradoException;
import br.com.fooddelivery.delivery_tracker.mapper.ItemPedidoMapper;
import br.com.fooddelivery.delivery_tracker.mapper.PedidoMapper;
import br.com.fooddelivery.delivery_tracker.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ItemPedidoMapper itemPedidoMapper;
    private final HistoricoPedidoService historicoService;

    @Transactional
    public PedidoResponse criarPedido(CriarPedidoRequest request) {

        Pedido pedido = new Pedido();

        pedido.setCliente(request.cliente());
        pedido.setEnderecoEntrega(request.enderecoEntrega());
        pedido.setStatus(StatusPedido.RECEBIDO);

        request.itens().forEach(itemRequest -> {
            ItemPedido item = itemPedidoMapper.toEntity(itemRequest);
            pedido.adicionarItem(item);
        });

        Pedido salvo = pedidoRepository.save(pedido);

        historicoService.registrar(
                salvo,
                StatusPedido.RECEBIDO
        );

        Pedido pedidoCompleto = pedidoRepository.findById(salvo.getId())
                .orElseThrow();

        return pedidoMapper.toResponse(pedidoCompleto);
    }

    @Transactional
    public List<PedidoResponse> listar() {

        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toResponse)
                .toList();
    }

    @Transactional
    public PedidoResponse buscarPorId(Long id) {

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Pedido não encontrado"));

        return pedidoMapper.toResponse(pedido);
    }
}