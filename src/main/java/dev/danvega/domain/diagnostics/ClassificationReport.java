package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificationReport {
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
