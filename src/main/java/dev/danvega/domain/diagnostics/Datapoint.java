package dev.danvega.domain.diagnostics;

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
public class Datapoint {
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
  private String label;
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "datapointId")
  private List<Point> points = new ArrayList<>();

}
