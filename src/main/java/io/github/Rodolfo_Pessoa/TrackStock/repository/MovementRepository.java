package io.github.Rodolfo_Pessoa.TrackStock.repository;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

}
