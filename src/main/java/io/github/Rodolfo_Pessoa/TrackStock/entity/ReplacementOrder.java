package io.github.Rodolfo_Pessoa.TrackStock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "replace_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplacementOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public void generateOrder(Product product, Supplier supplier, int quantity) {
        this.product = product;
        this.supplier = supplier;
        this.quantity = quantity;
        this.orderDate = LocalDate.now();
    }
}
