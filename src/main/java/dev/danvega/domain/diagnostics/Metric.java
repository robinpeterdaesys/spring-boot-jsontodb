package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Metric {
  @Id
  @SequenceGenerator(
          name = "metric_sequence",
          sequenceName = "metric_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "metric_sequence"
  )
  @JsonIgnore
  private Long metricId;
  private Long id;
  private String name;
  private Double value;

}
