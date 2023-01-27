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
  private Long datapointId;
  private String color;
  private Long width;
  private String label;
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "datapointId")
  private List<MlAiModelDiaRepPointEntity> points = new ArrayList<>();

}
