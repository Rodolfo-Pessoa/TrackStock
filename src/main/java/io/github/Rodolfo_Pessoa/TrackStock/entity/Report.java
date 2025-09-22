package io.github.Rodolfo_Pessoa.TrackStock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportType;
    private LocalDate generationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String generateReport(String type) {
        this.reportType = type;
        this.generationDate = LocalDate.now();
        return "Relatório do tipo '" + type + "' gerado em " + generationDate;
    }
}
