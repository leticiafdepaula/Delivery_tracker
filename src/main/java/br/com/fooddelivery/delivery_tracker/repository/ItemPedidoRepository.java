package br.com.fooddelivery.delivery_tracker.repository;

import br.com.fooddelivery.delivery_tracker.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
