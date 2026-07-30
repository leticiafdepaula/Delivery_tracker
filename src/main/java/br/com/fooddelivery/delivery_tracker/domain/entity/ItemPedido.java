package br.com.fooddelivery.delivery_tracker.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String produto;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}