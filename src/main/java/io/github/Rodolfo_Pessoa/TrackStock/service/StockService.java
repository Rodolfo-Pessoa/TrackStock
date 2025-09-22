package io.github.Rodolfo_Pessoa.TrackStock.service;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Product;
import io.github.Rodolfo_Pessoa.TrackStock.entity.Stock;
import io.github.Rodolfo_Pessoa.TrackStock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    public void delete(Long id) {
        stockRepository.deleteById(id);
    }

    public Stock addProduct(Long stockId, Product product) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock não encontrado"));
        stock.addProduct(product);
        return stockRepository.save(stock);
    }

    public Stock removeProduct(Long stockId, Product product) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock não encontrado"));
        stock.removeProduct(product);
        return stockRepository.save(stock);
    }

    public List<Product> checkMinimumStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock não encontrado"));
        return stock.checkMinimumStock();
    }
}
