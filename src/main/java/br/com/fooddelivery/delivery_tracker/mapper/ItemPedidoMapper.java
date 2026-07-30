package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import br.com.fooddelivery.delivery_tracker.dto.request.ItemPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.ItemPedidoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido toEntity(ItemPedidoRequest request);

    ItemPedidoResponse toResponse(ItemPedido item);
}