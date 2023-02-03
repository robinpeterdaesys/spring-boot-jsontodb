package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ML_AI_MODEL_DIA_REP_CHART")
public class MlAiModelDiaRepChartEntity {
  @Id
  @SequenceGenerator(
          name = "chart_sequence",
          sequenceName = "chart_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "chart_sequence"
  )
  @JsonIgnore
  @Column(name = "CHART_ID")
  private Long chartId;
  private Long id;
  private String name;
  private String charttype;
  private String title;
  private String xaxistitle;
  private String yaxistitle;

  public Double[] xaxislabels;

  public Double[] yaxislabels;

  @OneToMany(
          mappedBy = "chart",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<MlAiModelDiaRepDatapointEntity> datapoints;

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JsonBackReference(value = "chart-diagnosticsReport")
  @JoinColumn(name = "ML_AI_MODEL_DIA_REPORT_ID")
  private MlAiModelDiaReportEntity diagnosticsReport;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MlAiModelDiaRepChartEntity )) return false;
    return id != null && id.equals(((MlAiModelDiaRepChartEntity) o).getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
