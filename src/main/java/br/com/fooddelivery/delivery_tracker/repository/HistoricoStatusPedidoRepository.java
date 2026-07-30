package br.com.fooddelivery.delivery_tracker.repository;

import br.com.fooddelivery.delivery_tracker.domain.entity.HistoricoStatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoStatusPedidoRepository extends JpaRepository<HistoricoStatusPedido, Long> {

    List<HistoricoStatusPedido> findByPedidoIdOrderByDataAlteracaoAsc(Long pedidoId);

}
