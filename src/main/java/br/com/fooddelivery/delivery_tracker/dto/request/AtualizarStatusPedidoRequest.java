package br.com.fooddelivery.delivery_tracker.dto.request;


import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;

public record AtualizarStatusPedidoRequest(

        @NotNull(message = "Status obrigatório")
        StatusPedido status

) {
}