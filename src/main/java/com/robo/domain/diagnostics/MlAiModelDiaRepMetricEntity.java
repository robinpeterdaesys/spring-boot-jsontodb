package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ML_AI_MODEL_DIA_REP_METRIC")
public class MlAiModelDiaRepMetricEntity {
  @Id
  @SequenceGenerator(
          name = "metric_sequence",
          sequenceName = "metric_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "metric_sequence"
  )
  @JsonIgnore
  private Long metricId;
  private Long id;
  private String name;
  private Double value;

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "ML_AI_MODEL_DIA_REPORT_ID")
  @JsonBackReference(value = "metric-diagnosticsReport")
  private MlAiModelDiaReportEntity diagnosticsReport;
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MlAiModelDiaRepMetricEntity )) return false;
    return id != null && id.equals(((MlAiModelDiaRepMetricEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
