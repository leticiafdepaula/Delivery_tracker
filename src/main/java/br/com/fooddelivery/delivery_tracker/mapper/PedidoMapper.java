package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = "spring",
        uses = {ItemPedidoMapper.class,
                HistoricoStatusMapper.class
        }
)
public interface PedidoMapper {

    PedidoResponse toResponse(Pedido pedido);

}