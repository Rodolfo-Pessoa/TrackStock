package io.github.Rodolfo_Pessoa.TrackStock.repository;

import io.github.Rodolfo_Pessoa.TrackStock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
