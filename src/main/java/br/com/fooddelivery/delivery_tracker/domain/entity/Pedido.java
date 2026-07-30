package br.com.fooddelivery.delivery_tracker.domain.entity;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String enderecoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Builder.Default
    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemPedido> itens = new ArrayList<>();

    @PrePersist
    public void prePersist() {

        dataCriacao = LocalDateTime.now();

        if (status == null) {
            status = StatusPedido.RECEBIDO;
        }
    }
}