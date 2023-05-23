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
public class MlAiModelExpRepDatapointEntity {
  @Id
  @SequenceGenerator(
          name = "exp_datapoint_sequence",
          sequenceName = "exp_datapoint_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "exp_datapoint_sequence"
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
  @JoinColumn(name = "expDatapointId")
  private List<MlAiModelExpRepPointEntity> points = new ArrayList<>();

}
