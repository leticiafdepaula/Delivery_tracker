package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import br.com.fooddelivery.delivery_tracker.dto.request.ItemPedidoRequest;
import br.com.fooddelivery.delivery_tracker.dto.response.ItemPedidoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-30T19:42:41-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Microsoft)"
)
@Component
public class ItemPedidoMapperImpl implements ItemPedidoMapper {

    @Override
    public ItemPedido toEntity(ItemPedidoRequest request) {
        if ( request == null ) {
            return null;
        }

        ItemPedido.ItemPedidoBuilder itemPedido = ItemPedido.builder();

        itemPedido.produto( request.produto() );
        itemPedido.quantidade( request.quantidade() );

        return itemPedido.build();
    }

    @Override
    public ItemPedidoResponse toResponse(ItemPedido item) {
        if ( item == null ) {
            return null;
        }

        Long id = null;
        Integer quantidade = null;

        id = item.getId();
        quantidade = item.getQuantidade();

        String nome = null;

        ItemPedidoResponse itemPedidoResponse = new ItemPedidoResponse( id, nome, quantidade );

        return itemPedidoResponse;
    }
}
