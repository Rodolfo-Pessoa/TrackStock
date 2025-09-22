package io.github.Rodolfo_Pessoa.TrackStock.controller;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Product;
import io.github.Rodolfo_Pessoa.TrackStock.entity.Stock;
import io.github.Rodolfo_Pessoa.TrackStock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return stockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/products")
    public Stock addProduct(@PathVariable Long id, @RequestBody Product product) {
        return stockService.addProduct(id, product);
    }

    @DeleteMapping("/{id}/products")
    public Stock removeProduct(@PathVariable Long id, @RequestBody Product product) {
        return stockService.removeProduct(id, product);
    }

    @GetMapping("/{id}/minimum")
    public List<Product> checkMinimumStock(@PathVariable Long id) {
        return stockService.checkMinimumStock(id);
    }
}
