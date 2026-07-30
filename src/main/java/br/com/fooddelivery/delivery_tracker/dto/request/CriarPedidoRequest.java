package br.com.fooddelivery.delivery_tracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CriarPedidoRequest(

        @NotBlank(message = "Cliente obrigatório")
        String cliente,

        @NotBlank(message = "Endereço obrigatório")
        String enderecoEntrega,

        @NotEmpty(message = "Pedido deve possuir itens")
        List<ItemPedidoRequest> itens

) {
}