package br.com.fooddelivery.delivery_tracker.repository;

import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
