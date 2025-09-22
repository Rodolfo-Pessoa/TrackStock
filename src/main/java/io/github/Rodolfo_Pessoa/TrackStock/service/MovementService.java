package io.github.Rodolfo_Pessoa.TrackStock.service;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Movement;
import io.github.Rodolfo_Pessoa.TrackStock.repository.MovementRepository;
import io.github.Rodolfo_Pessoa.TrackStock.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    private final MovementRepository movementRepository;
    private final ProductRepository productRepository;

    public MovementService(MovementRepository movementRepository, ProductRepository productRepository) {
        this.movementRepository = movementRepository;
        this.productRepository = productRepository;
    }

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> findById(Long id) {
        return movementRepository.findById(id);
    }

    public Movement save(Movement movement) {
        if (movement.getDate() == null) {
            movement.setDate(LocalDate.now());
        }

        movement.register();
        productRepository.save(movement.getProduct());

        return movementRepository.save(movement);
    }

    public void delete(Long id) {
        movementRepository.deleteById(id);
    }
}
