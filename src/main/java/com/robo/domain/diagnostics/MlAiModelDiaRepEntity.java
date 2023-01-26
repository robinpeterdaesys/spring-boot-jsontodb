package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MlAiModelDiaRepEntity {
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
  private Long diagnosticsReportId;
  private Long modelId;
  private Long diagnosticsDefinitionId;
  private Long diagnosticsId;
  private Long[][] confusionMatrix;
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  @MapKeyColumn(name="CLASSIFICATION_REPORT_TYPE")
  private Map<String, MlAiModelDiaRepClassificationReportEntity> classificationReport;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  @MapKeyColumn(name="LIFT_GAIN_TYPE")
  private Map<String, MlAiModelDiaRepLiftGainEntity> liftGain;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<MlAiModelDiaRepMetricEntity> metrics = new ArrayList<>();

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<MlAiModelDiaRepChartEntity> charts = new ArrayList<>();

}
