package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
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

}
