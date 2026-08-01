package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.HistoricoStatusPedido;
import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.dto.response.HistoricoStatusResponse;
import br.com.fooddelivery.delivery_tracker.dto.response.ItemPedidoResponse;
import br.com.fooddelivery.delivery_tracker.dto.response.PedidoResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-31T22:58:08-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Microsoft)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;
    @Autowired
    private HistoricoStatusMapper historicoStatusMapper;

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
        List<HistoricoStatusResponse> historico = null;

        id = pedido.getId();
        cliente = pedido.getCliente();
        enderecoEntrega = pedido.getEnderecoEntrega();
        status = pedido.getStatus();
        dataCriacao = pedido.getDataCriacao();
        itens = itemPedidoSetToItemPedidoResponseList( pedido.getItens() );
        historico = historicoStatusPedidoSetToHistoricoStatusResponseList( pedido.getHistorico() );

        PedidoResponse pedidoResponse = new PedidoResponse( id, cliente, enderecoEntrega, status, dataCriacao, itens, historico );

        return pedidoResponse;
    }

    protected List<ItemPedidoResponse> itemPedidoSetToItemPedidoResponseList(Set<ItemPedido> set) {
        if ( set == null ) {
            return null;
        }

        List<ItemPedidoResponse> list = new ArrayList<ItemPedidoResponse>( set.size() );
        for ( ItemPedido itemPedido : set ) {
            list.add( itemPedidoMapper.toResponse( itemPedido ) );
        }

        return list;
    }

    protected List<HistoricoStatusResponse> historicoStatusPedidoSetToHistoricoStatusResponseList(Set<HistoricoStatusPedido> set) {
        if ( set == null ) {
            return null;
        }

        List<HistoricoStatusResponse> list = new ArrayList<HistoricoStatusResponse>( set.size() );
        for ( HistoricoStatusPedido historicoStatusPedido : set ) {
            list.add( historicoStatusMapper.toResponse( historicoStatusPedido ) );
        }

        return list;
    }
}
