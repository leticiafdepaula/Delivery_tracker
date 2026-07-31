package br.com.fooddelivery.delivery_tracker.dto.response;

public record ItemPedidoResponse(

        Long id,

        String produto,

        Integer quantidade

) {}