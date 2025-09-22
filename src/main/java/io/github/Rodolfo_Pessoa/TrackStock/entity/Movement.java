package io.github.Rodolfo_Pessoa.TrackStock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "movement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String type;
    private Integer quantity;
    private LocalDate date;

    public void register() {
        if ("ENTRADA".equalsIgnoreCase(type)) {
            product.replace(quantity);
        } else if ("SAÍDA".equalsIgnoreCase(type)) {
            product.remove(quantity);
        } else {
            throw new IllegalArgumentException("Tipo de movimentação inválido.");
        }
    }
}
