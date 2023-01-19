package dev.danvega.repository;

import dev.danvega.domain.diagnostics.DiagnosticsReport;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosticsReportRepository extends CrudRepository<DiagnosticsReport,Long> {
}
