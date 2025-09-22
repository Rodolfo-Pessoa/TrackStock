package io.github.Rodolfo_Pessoa.TrackStock.repository;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
