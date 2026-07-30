package br.com.fooddelivery.delivery_tracker.dto.response;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;

import java.time.LocalDateTime;

public record HistoricoStatusResponse(

        StatusPedido status,

        LocalDateTime dataAlteracao
) {
}