package br.com.fooddelivery.delivery_tracker.dto.response;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponse(

        Long id,

        String cliente,

        String enderecoEntrega,

        StatusPedido status,

        LocalDateTime dataCriacao,

        List<ItemPedidoResponse> itens,

        List<HistoricoStatusResponse> historico
) {
}