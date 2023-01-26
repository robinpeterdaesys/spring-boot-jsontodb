package com.robo.service;

import com.robo.repository.MlAiModelDiaRepRepository;
import com.robo.domain.diagnostics.MlAiModelDiaRepEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MlAiModelDiaRepService {

  private final MlAiModelDiaRepRepository diagnosticsReportRepository;

  public MlAiModelDiaRepService(MlAiModelDiaRepRepository diagnosticsReportRepository) {
    this.diagnosticsReportRepository = diagnosticsReportRepository;
  }

  public Iterable<MlAiModelDiaRepEntity> list() {
    return diagnosticsReportRepository.findAll();
  }

  public MlAiModelDiaRepEntity save(MlAiModelDiaRepEntity diagnosticsReport) {
    return diagnosticsReportRepository.save(diagnosticsReport);
  }

  public void save(List<MlAiModelDiaRepEntity> diagnosticsReports) {
    diagnosticsReportRepository.saveAll(diagnosticsReports);
  }
}
