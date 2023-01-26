package com.robo.controller;

import com.robo.domain.diagnostics.MlAiModelDiaRepEntity;
import com.robo.service.MlAiModelDiaRepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnostics-reports")
public class MlAiModelDiaRepController {

    private final MlAiModelDiaRepService diagnosticsReportService;

    public MlAiModelDiaRepController(MlAiModelDiaRepService diagnosticsReportService) {
        this.diagnosticsReportService = diagnosticsReportService;
    }

    @GetMapping("/list")
    public Iterable<MlAiModelDiaRepEntity> list() {
        return diagnosticsReportService.list();
    }

}
