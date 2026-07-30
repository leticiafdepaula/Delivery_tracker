package br.com.fooddelivery.delivery_tracker.domain.entity;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_historico_status_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoStatusPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    @Column(nullable = false)
    private LocalDateTime dataAlteracao;

    @PrePersist
    public void prePersist() {
        dataAlteracao = LocalDateTime.now();
    }
}
