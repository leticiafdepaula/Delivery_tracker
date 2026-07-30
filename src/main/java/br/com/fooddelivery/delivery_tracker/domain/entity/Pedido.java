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

    private String cliente;

    private String enderecoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    private LocalDateTime dataCriacao;

    @Builder.Default
    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido item) {

        itens.add(item);
        item.setPedido(this);

    }

    @PrePersist
    public void prePersist() {

        dataCriacao = LocalDateTime.now();

        if (status == null) {
            status = StatusPedido.RECEBIDO;
        }
    }
}