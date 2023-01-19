package dev.danvega.domain.diagnostics;

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
public class Chart {
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
  private List<Datapoint> datapoints = new ArrayList<>();

}
