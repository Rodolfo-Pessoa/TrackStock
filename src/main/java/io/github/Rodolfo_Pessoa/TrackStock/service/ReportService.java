package io.github.Rodolfo_Pessoa.TrackStock.service;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Report;
import io.github.Rodolfo_Pessoa.TrackStock.entity.User;
import io.github.Rodolfo_Pessoa.TrackStock.repository.ReportRepository;
import io.github.Rodolfo_Pessoa.TrackStock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }

    public Report generateReport(Long userId, String type) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Report report = new Report();
        report.setUser(user);
        report.setReportType(type);
        report.setGenerationDate(LocalDate.now());

        return reportRepository.save(report);
    }

    public void delete(Long id) {
        reportRepository.deleteById(id);
    }
}
