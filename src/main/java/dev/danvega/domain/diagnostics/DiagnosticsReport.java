package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.danvega.domain.enums.ClassificationReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticsReport {
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
  @MapKeyEnumerated(EnumType.STRING)
  private Map<ClassificationReportType,ClassificationReport> classificationReport = new HashMap<>();

//  @OneToOne(
//          cascade = CascadeType.ALL,
//          orphanRemoval = true
//  )
//  @JoinColumn(name = "diagnosticsReportId")
//  private LiftGain liftGain;

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<Metric> metrics = new ArrayList<>();

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "diagnosticsReportId")
  private List<Chart> charts = new ArrayList<>();

}
