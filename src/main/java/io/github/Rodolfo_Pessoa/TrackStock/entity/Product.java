package io.github.Rodolfo_Pessoa.TrackStock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private Integer quantity;
    private Integer minimumQuantity;
    private LocalDate validity;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @JsonIgnore
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public void replace(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }

    public void remove(int quantity) {
        if (quantity > 0 && this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            throw new IllegalArgumentException("Quantidade inválida ou insuficiente em estoque.");
        }
    }

    public boolean expired() {
        return validity != null && validity.isBefore(LocalDate.now());
    }
}