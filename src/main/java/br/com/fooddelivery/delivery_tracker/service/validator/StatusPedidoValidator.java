package br.com.fooddelivery.delivery_tracker.service.validator;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import br.com.fooddelivery.delivery_tracker.exception.RegraNegocioException;
import org.springframework.stereotype.Component;

@Component
public class StatusPedidoValidator {

    public void validar(
            StatusPedido atual,
            StatusPedido novo
    ) {

        if (atual == StatusPedido.ENTREGUE) {

            throw new RegraNegocioException(
                    "Pedido já entregue"
            );

        }

    }
}