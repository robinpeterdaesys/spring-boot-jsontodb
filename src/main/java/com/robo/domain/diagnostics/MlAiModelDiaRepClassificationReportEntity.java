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
@Table(name = "ML_AI_MODEL_DIA_REP_CLASSIFICATION_REPORT")
public class MlAiModelDiaRepClassificationReportEntity {
  @Id
  @SequenceGenerator(
          name = "classification_report_sequence",
          sequenceName = "classification_report_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "classification_report_sequence"
  )
  @JsonIgnore
  private Long classificationReportId;
  private Double precision;
  private Double recall;
  private Double f1Score;
  private Long support;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MlAiModelDiaRepClassificationReportEntity that = (MlAiModelDiaRepClassificationReportEntity) o;

    return classificationReportId.equals(that.classificationReportId);
  }

  @Override
  public int hashCode() {
    return classificationReportId.hashCode();
  }

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JsonBackReference(value = "classificationReport-diagnosticsReport")
  @JoinColumn(name = "ML_AI_MODEL_DIA_REPORT_ID")
  private MlAiModelDiaReportEntity diagnosticsReport;
}
