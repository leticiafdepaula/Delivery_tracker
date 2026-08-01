package br.com.fooddelivery.delivery_tracker.domain.entity;

import br.com.fooddelivery.delivery_tracker.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private Set<ItemPedido> itens =  new LinkedHashSet<>();

    @OrderBy("dataAlteracao ASC")
    @Builder.Default
    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<HistoricoStatusPedido> historico =  new LinkedHashSet<>();

    public void adicionarItem(ItemPedido item) {

        this.itens.add(item);
        item.setPedido(this);

    }

    public void adicionarHistorico(HistoricoStatusPedido historico) {

        this.historico.add(historico);
        historico.setPedido(this);

    }

    @PrePersist
    public void prePersist() {

        dataCriacao = LocalDateTime.now();

        if (status == null) {
            status = StatusPedido.RECEBIDO;
        }

    }
}