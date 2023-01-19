package dev.danvega.domain.diagnostics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
  private Long id;
  private Long diagnosticsReportId;
  private Long modelId;
  private Long diagnosticsDefinitionId;
  private Long diagnosticsId;
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Metric> metrics = new ArrayList<>();

  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Chart> charts = new ArrayList<>();

}
