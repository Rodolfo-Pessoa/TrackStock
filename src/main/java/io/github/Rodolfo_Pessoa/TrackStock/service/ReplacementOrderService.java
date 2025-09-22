package io.github.Rodolfo_Pessoa.TrackStock.service;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Product;
import io.github.Rodolfo_Pessoa.TrackStock.entity.ReplacementOrder;
import io.github.Rodolfo_Pessoa.TrackStock.entity.Supplier;
import io.github.Rodolfo_Pessoa.TrackStock.repository.ProductRepository;
import io.github.Rodolfo_Pessoa.TrackStock.repository.ReplacementOrderRepository;
import io.github.Rodolfo_Pessoa.TrackStock.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReplacementOrderService {

    private final ReplacementOrderRepository replacementOrderRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ReplacementOrderService(ReplacementOrderRepository replacementOrderRepository,
                                   ProductRepository productRepository,
                                   SupplierRepository supplierRepository) {
        this.replacementOrderRepository = replacementOrderRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<ReplacementOrder> findAll() {
        return replacementOrderRepository.findAll();
    }

    public Optional<ReplacementOrder> findById(Long id) {
        return replacementOrderRepository.findById(id);
    }

    public ReplacementOrder createOrder(Long productId, Long supplierId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        ReplacementOrder order = new ReplacementOrder();
        order.generateOrder(product, supplier, quantity);
        order.setOrderDate(LocalDate.now());

        return replacementOrderRepository.save(order);
    }

    public void delete(Long id) {
        replacementOrderRepository.deleteById(id);
    }
}
