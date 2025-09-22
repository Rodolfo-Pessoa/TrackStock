package io.github.Rodolfo_Pessoa.TrackStock.controller;

import io.github.Rodolfo_Pessoa.TrackStock.entity.ReplacementOrder;
import io.github.Rodolfo_Pessoa.TrackStock.service.ReplacementOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replacement-orders")
public class ReplacementOrderController {

    private final ReplacementOrderService replacementOrderService;

    public ReplacementOrderController(ReplacementOrderService replacementOrderService) {
        this.replacementOrderService = replacementOrderService;
    }

    @GetMapping
    public List<ReplacementOrder> getAll() {
        return replacementOrderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplacementOrder> getById(@PathVariable Long id) {
        return replacementOrderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReplacementOrder create(@RequestParam Long productId,
                                   @RequestParam Long supplierId,
                                   @RequestParam int quantity) {
        return replacementOrderService.createOrder(productId, supplierId, quantity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        replacementOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
