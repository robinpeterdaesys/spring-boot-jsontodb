package dev.danvega.controller;

import dev.danvega.domain.diagnostics.DiagnosticsReport;
import dev.danvega.service.DiagnosticsReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnostics-reports")
public class DiagnosticsReportController {

    private DiagnosticsReportService diagnosticsReportService;

    public DiagnosticsReportController(DiagnosticsReportService diagnosticsReportService) {
        this.diagnosticsReportService = diagnosticsReportService;
    }

    @GetMapping("/list")
    public Iterable<DiagnosticsReport> list() {
        return diagnosticsReportService.list();
    }

}
