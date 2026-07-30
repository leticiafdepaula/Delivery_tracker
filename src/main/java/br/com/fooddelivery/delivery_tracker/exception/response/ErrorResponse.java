package br.com.fooddelivery.delivery_tracker.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(

        LocalDateTime timestamp,

        Integer status,

        String erro,

        String mensagem,

        String caminho,

        Map<String, String> erros

) {
}