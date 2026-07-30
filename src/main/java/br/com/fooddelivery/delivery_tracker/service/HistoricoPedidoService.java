package br.com.fooddelivery.delivery_tracker.service;

import br.com.fooddelivery.delivery_tracker.domain.entity.HistoricoStatusPedido;
import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.repository.HistoricoStatusPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricoPedidoService {

    private final HistoricoStatusPedidoRepository repository;


    public void registrar(
            Pedido pedido,
            StatusPedido status
    ){

        HistoricoStatusPedido historico =
                HistoricoStatusPedido.builder()
                        .pedido(pedido)
                        .status(status)
                        .build();

        repository.save(historico);

    }
}