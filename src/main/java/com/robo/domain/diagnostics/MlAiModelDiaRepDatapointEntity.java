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
@Table(name = "ML_AI_MODEL_DIA_REP_DATAPOINT")
public class MlAiModelDiaRepDatapointEntity {
  @Id
  @SequenceGenerator(
          name = "datapoint_sequence",
          sequenceName = "datapoint_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "datapoint_sequence"
  )
  @JsonIgnore
  @Column(name = "DATAPOINT_ID")
  private Long datapointId;
  private String color;
  private Long width;
  private String label;

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "ML_AI_MODEL_DIA_REP_CHART_ID")
  @JsonBackReference(value = "datapoint-chart")
  private MlAiModelDiaRepChartEntity chart;
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MlAiModelDiaRepDatapointEntity )) return false;
    return datapointId != null && datapointId.equals(((MlAiModelDiaRepDatapointEntity) o).getDatapointId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  @OneToMany(
          mappedBy = "datapoint",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<MlAiModelDiaRepPointEntity> points;

}
