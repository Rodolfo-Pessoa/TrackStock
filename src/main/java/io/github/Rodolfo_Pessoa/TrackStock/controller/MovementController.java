package io.github.Rodolfo_Pessoa.TrackStock.controller;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Movement;
import io.github.Rodolfo_Pessoa.TrackStock.service.MovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping
    public List<Movement> getAll() {
        return movementService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movement> getById(@PathVariable Long id) {
        return movementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movement create(@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
