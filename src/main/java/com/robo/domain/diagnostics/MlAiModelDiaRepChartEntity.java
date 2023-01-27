package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "chartId")
  private Set<MlAiModelDiaRepDatapointEntity> datapoints = new HashSet<>();

}
