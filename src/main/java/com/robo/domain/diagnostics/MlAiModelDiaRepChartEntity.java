package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JoinColumn(name = "chartId")
  private List<MlAiModelDiaRepDatapointEntity> datapoints = new ArrayList<>();
  public void addDatapoint(MlAiModelDiaRepDatapointEntity datapoint) {
    datapoints.add(datapoint);
    datapoint.setChart(this);
  }
  public void removeDatapoint(MlAiModelDiaRepDatapointEntity datapoint) {
    datapoints.remove(datapoint);
    datapoint.setChart(null);
  }

  @ManyToOne
  @JoinColumn(name = "ML_AI_MODEL_DIA_REP_CHART_DIA_REPORT_ID")
  private MlAiModelDiaReportEntity diagnosticsReport;
}
