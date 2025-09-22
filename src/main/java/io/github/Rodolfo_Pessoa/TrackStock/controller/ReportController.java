package io.github.Rodolfo_Pessoa.TrackStock.controller;

import io.github.Rodolfo_Pessoa.TrackStock.entity.Report;
import io.github.Rodolfo_Pessoa.TrackStock.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> getAll() {
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getById(@PathVariable Long id) {
        return reportService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Report create(@RequestParam Long userId,
                         @RequestParam String type) {
        return reportService.generateReport(userId, type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
