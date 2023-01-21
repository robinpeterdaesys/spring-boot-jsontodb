package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;

public class SemiDecile {
  @Id
  @SequenceGenerator(
          name = "semi_decile_sequence",
          sequenceName = "semi_decile_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "semi_decile_sequence"
  )
  @JsonIgnore
  private Long semiDecileId;

  private Integer[] values = new Integer[20];

}
