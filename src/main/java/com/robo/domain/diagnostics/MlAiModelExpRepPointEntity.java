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
public class MlAiModelExpRepPointEntity {
  @Id
  @SequenceGenerator(
          name = "exp_point_sequence",
          sequenceName = "exp_point_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "exp_point_sequence"
  )
  @JsonIgnore
  private Long pointId;
  private Double x;
  private String y;

}
