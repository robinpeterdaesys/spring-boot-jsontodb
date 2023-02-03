package com.robo.service;

import com.robo.repository.MlAiModelDiaRepRepository;
import com.robo.domain.diagnostics.MlAiModelDiaReportEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MlAiModelDiaRepService {

  private final MlAiModelDiaRepRepository diagnosticsReportRepository;

  public MlAiModelDiaRepService(MlAiModelDiaRepRepository diagnosticsReportRepository) {
    this.diagnosticsReportRepository = diagnosticsReportRepository;
  }

  public Iterable<MlAiModelDiaReportEntity> list() {
    return diagnosticsReportRepository.findAll();
  }

  public MlAiModelDiaReportEntity save(@NotNull MlAiModelDiaReportEntity diagnosticsReport) {

    //Setting the mapping keys to corresponding columns ---STARTS-----
    Optional.ofNullable(diagnosticsReport.getMetrics()).orElse(Collections.emptyList())
            .forEach(metric -> metric.setDiagnosticsReport(diagnosticsReport));
    Optional.ofNullable(diagnosticsReport.getCharts()).orElse(Collections.emptyList()).forEach(chart -> {
      chart.setDiagnosticsReport(diagnosticsReport);
      Optional.ofNullable(chart.getDatapoints()).orElse(Collections.emptyList())
      .forEach(datapoint->{
        datapoint.setChart(chart);
        Optional.ofNullable(datapoint.getPoints()).orElse(Collections.emptyList())
        .forEach(point-> point.setDatapoint(datapoint));
      });
    });
    Optional.ofNullable(diagnosticsReport.getLiftGain()).orElse(Collections.emptyMap()).values()
            .forEach(liftGain -> liftGain.setDiagnosticsReport(diagnosticsReport));
    Optional.ofNullable(diagnosticsReport.getClassificationReport()).orElse(Collections.emptyMap()).values()
            .forEach(classificationReport -> classificationReport.setDiagnosticsReport(diagnosticsReport));
    //Setting the mapping keys to corresponding columns ---ENDS-----

    return diagnosticsReportRepository.save(diagnosticsReport);
  }

  public void save(List<MlAiModelDiaReportEntity> diagnosticsReports) {
    diagnosticsReportRepository.saveAll(diagnosticsReports);
  }
}
