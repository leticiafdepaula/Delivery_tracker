package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.HistoricoStatusPedido;
import br.com.fooddelivery.delivery_tracker.dto.response.HistoricoStatusResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoStatusMapper {

    HistoricoStatusResponse toResponse(HistoricoStatusPedido historico);

}