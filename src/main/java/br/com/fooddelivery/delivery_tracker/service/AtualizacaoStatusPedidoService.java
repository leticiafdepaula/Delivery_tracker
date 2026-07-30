package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.dto.request.AtualizarStatusPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import br.com.fooddelivery.delivery_tracker.exception.RecursoNaoEncontradoException;
import br.com.fooddelivery.delivery_tracker.mapper.PedidoMapper;
import br.com.fooddelivery.delivery_tracker.repository.PedidoRepository;
import br.com.fooddelivery.delivery_tracker.service.validator.StatusPedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository pedidoRepository;
    private final HistoricoPedidoService historicoService;
    private final StatusPedidoValidator validator;
    private final PedidoMapper pedidoMapper;


    public PedidoResponse atualizar(
            Long id,
            AtualizarStatusPedidoRequest request
    ){

        Pedido pedido =
                pedidoRepository.findById(id)
                        .orElseThrow(() ->
                                new RecursoNaoEncontradoException(
                                        "Pedido não encontrado"
                                )
                        );

        validator.validar(
                pedido.getStatus(),
                request.status()
        );

        pedido.setStatus(
                request.status()
        );

        Pedido salvo =
                pedidoRepository.save(pedido);


        historicoService.registrar(
                salvo,
                request.status()
        );

        return pedidoMapper.toResponse(salvo);

    }
}