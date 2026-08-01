package br.com.fooddelivery.delivery_tracker.repository;

import br.com.fooddelivery.delivery_tracker.domain.entity.Pedido;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @EntityGraph(attributePaths = {
            "itens",
            "historico"
    })
    Optional<Pedido> findComItensEHistoricoById(Long id);

    @EntityGraph(attributePaths = {
            "itens",
            "historico"
    })

    List<Pedido> findAllBy();
}
