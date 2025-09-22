package io.github.Rodolfo_Pessoa.TrackStock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<ReplacementOrder> orders = new ArrayList<>();

    public Product sendRequest(Product product, int quantity) {
        if (product != null && quantity > 0) {
            product.replace(quantity);
            return product;
        }
        throw new IllegalArgumentException("Produto inválido ou quantidade não permitida.");
    }
}
