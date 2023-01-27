package com.robo.service;

import com.robo.repository.MlAiModelDiaRepRepository;
import com.robo.domain.diagnostics.MlAiModelDiaReportEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MlAiModelDiaRepService {

  private final MlAiModelDiaRepRepository diagnosticsReportRepository;

  public MlAiModelDiaRepService(MlAiModelDiaRepRepository diagnosticsReportRepository) {
    this.diagnosticsReportRepository = diagnosticsReportRepository;
  }

  public Iterable<MlAiModelDiaReportEntity> list() {
    return diagnosticsReportRepository.findAll();
  }

  public MlAiModelDiaReportEntity save(MlAiModelDiaReportEntity diagnosticsReport) {
    return diagnosticsReportRepository.save(diagnosticsReport);
  }

  public void save(List<MlAiModelDiaReportEntity> diagnosticsReports) {
    diagnosticsReportRepository.saveAll(diagnosticsReports);
  }
}
