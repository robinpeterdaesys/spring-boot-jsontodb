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
@Table(name = "ML_AI_MODEL_DIA_REP_POINT")
public class MlAiModelDiaRepPointEntity {
  @Id
  @SequenceGenerator(
          name = "point_sequence",
          sequenceName = "point_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "point_sequence"
  )
  @JsonIgnore
  private Long pointId;
  private Double x;
  private Double y;
  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "ML_AI_MODEL_DIA_REP_DATAPOINT_ID")
  @JsonBackReference(value = "point-chart")
  private MlAiModelDiaRepDatapointEntity datapoint;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MlAiModelDiaRepPointEntity that = (MlAiModelDiaRepPointEntity) o;

    return pointId.equals(that.pointId);
  }

  @Override
  public int hashCode() {
    return pointId.hashCode();
  }
}
