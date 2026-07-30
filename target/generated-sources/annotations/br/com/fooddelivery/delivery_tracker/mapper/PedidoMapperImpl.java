package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.dto.response.HistoricoStatusResponse;
import br.com.fooddelivery.delivery_tracker.dto.response.ItemPedidoResponse;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-30T16:46:46-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Microsoft)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    @Override
    public PedidoResponse toResponse(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        Long id = null;
        String cliente = null;
        String enderecoEntrega = null;
        StatusPedido status = null;
        LocalDateTime dataCriacao = null;
        List<ItemPedidoResponse> itens = null;

        id = pedido.getId();
        cliente = pedido.getCliente();
        enderecoEntrega = pedido.getEnderecoEntrega();
        status = pedido.getStatus();
        dataCriacao = pedido.getDataCriacao();
        itens = itemPedidoListToItemPedidoResponseList( pedido.getItens() );

        List<HistoricoStatusResponse> historico = null;

        PedidoResponse pedidoResponse = new PedidoResponse( id, cliente, enderecoEntrega, status, dataCriacao, itens, historico );

        return pedidoResponse;
    }

    protected List<ItemPedidoResponse> itemPedidoListToItemPedidoResponseList(List<ItemPedido> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemPedidoResponse> list1 = new ArrayList<ItemPedidoResponse>( list.size() );
        for ( ItemPedido itemPedido : list ) {
            list1.add( itemPedidoMapper.toResponse( itemPedido ) );
        }

        return list1;
    }
}
