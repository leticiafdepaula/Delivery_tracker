package br.com.fooddelivery.delivery_tracker.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ItemPedidoRequest(

        @NotBlank(message = "Produto obrigatório")
        String produto,

        @Min(
                value = 1,
                message = "Quantidade deve ser maior que zero"
        )
        Integer quantidade

) {
}