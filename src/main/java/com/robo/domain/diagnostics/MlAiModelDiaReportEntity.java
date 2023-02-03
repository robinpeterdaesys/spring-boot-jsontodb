package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
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
  @MapKeyColumn(name="CLASSIFICATION_REPORT_TYPE")
  private Map<String, MlAiModelDiaRepClassificationReportEntity> classificationReport;

  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @MapKeyColumn(name="LIFT_GAIN_TYPE")
  private Map<String, MlAiModelDiaRepLiftGainEntity> liftGain;

  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<MlAiModelDiaRepMetricEntity> metrics = new ArrayList<>();

  @OneToMany(
          mappedBy = "diagnosticsReport",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<MlAiModelDiaRepChartEntity> charts = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MlAiModelDiaReportEntity that = (MlAiModelDiaReportEntity) o;

    return diagnosticsReportId.equals(that.diagnosticsReportId);
  }

  @Override
  public int hashCode() {
    return diagnosticsReportId.hashCode();
  }
}
