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

}
