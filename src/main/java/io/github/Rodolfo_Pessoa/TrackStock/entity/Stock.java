package io.github.Rodolfo_Pessoa.TrackStock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            product.setStock(this);
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        if (product != null && products.contains(product)) {
            products.remove(product);
            product.setStock(null);
        }
    }

    public Product consultProduct(Long id) {
        if (id == null) return null;
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Product> checkMinimumStock() {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantity() < product.getMinimumQuantity()) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}