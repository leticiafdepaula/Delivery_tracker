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

        if (atual == StatusPedido.CANCELADO) {
            throw new RegraNegocioException(
                    "Pedido já cancelado"
            );
        }

        switch (atual) {

            case RECEBIDO -> {
                if (novo != StatusPedido.EM_PREPARO &&
                        novo != StatusPedido.CANCELADO) {
                    throw new RegraNegocioException(
                            "Pedido já cancelado."
                    );
                }
            }

            case EM_PREPARO -> {
                if (novo != StatusPedido.SAIU_PARA_ENTREGA &&
                        novo != StatusPedido.CANCELADO) {
                    throw new RegraNegocioException(
                            "Pedido já cancelado."
                    );
                }
            }

            case SAIU_PARA_ENTREGA -> {
                if (novo != StatusPedido.ENTREGUE) {
                    throw new RegraNegocioException(
                            "Pedido já cancelado."
                    );
                }
            }

            default -> {
            }
        }
    }
}