package dev.danvega.service;

import dev.danvega.domain.diagnostics.DiagnosticsReport;
import dev.danvega.repository.DiagnosticsReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticsReportService {

  private final DiagnosticsReportRepository diagnosticsReportRepository;

  public DiagnosticsReportService(DiagnosticsReportRepository diagnosticsReportRepository) {
    this.diagnosticsReportRepository = diagnosticsReportRepository;
  }

  public Iterable<DiagnosticsReport> list() {
    return diagnosticsReportRepository.findAll();
  }

  public DiagnosticsReport save(DiagnosticsReport diagnosticsReport) {
    return diagnosticsReportRepository.save(diagnosticsReport);
  }

  public void save(List<DiagnosticsReport> diagnosticsReports) {
    diagnosticsReportRepository.saveAll(diagnosticsReports);
  }
}
