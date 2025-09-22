package io.github.Rodolfo_Pessoa.TrackStock.repository;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
