package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ML_AI_MODEL_DIA_REPORT")
public class MlAiModelDiaReportEntity {
  @Id
  @SequenceGenerator(
          name = "diagnostics_report_sequence",
          sequenceName = "diagnostics_report_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "diagnostics_report_sequence"
  )
  @JsonIgnore
  @Column(name = "DIAGNOSTICS_REPORT_ID")
  private Long diagnosticsReportId;
  private Long modelId;
  private Long diagnosticsDefinitionId;
  private Long diagnosticsId;
  private Long[][] confusionMatrix;
  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  @MapKeyColumn(name="CLASSIFICATION_REPORT_TYPE")
  private Map<String, MlAiModelDiaRepClassificationReportEntity> classificationReports;

  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  @MapKeyColumn(name="LIFT_GAIN_TYPE")
  private Map<String, MlAiModelDiaRepLiftGainEntity> liftGains;


  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<MlAiModelDiaRepMetricEntity> metrics = new ArrayList<>();

  public void addMetric(MlAiModelDiaRepMetricEntity metric) {
    metrics.add(metric);
    metric.setDiagnosticsReport(this);
  }

  public void removeMetric(MlAiModelDiaRepMetricEntity metric) {
    metrics.remove(metric);
    metric.setDiagnosticsReport(null);
  }

  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<MlAiModelDiaRepChartEntity> charts = new ArrayList<>();

  public void addChart(MlAiModelDiaRepChartEntity chart) {
    charts.add(chart);
    chart.setDiagnosticsReport(this);
  }

  public void removePoint(MlAiModelDiaRepChartEntity chart) {
    charts.remove(chart);
    chart.setDiagnosticsReport(null);
  }
}
