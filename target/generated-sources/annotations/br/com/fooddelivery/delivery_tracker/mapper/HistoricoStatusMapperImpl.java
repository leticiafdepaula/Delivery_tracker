package br.com.fooddelivery.delivery_tracker.mapper;

import br.com.fooddelivery.delivery_tracker.domain.entity.HistoricoStatusPedido;
import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.dto.response.HistoricoStatusResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-31T22:58:08-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Microsoft)"
)
@Component
public class HistoricoStatusMapperImpl implements HistoricoStatusMapper {

    @Override
    public HistoricoStatusResponse toResponse(HistoricoStatusPedido historico) {
        if ( historico == null ) {
            return null;
        }

        StatusPedido status = null;
        LocalDateTime dataAlteracao = null;

        status = historico.getStatus();
        dataAlteracao = historico.getDataAlteracao();

        HistoricoStatusResponse historicoStatusResponse = new HistoricoStatusResponse( status, dataAlteracao );

        return historicoStatusResponse;
    }
}
