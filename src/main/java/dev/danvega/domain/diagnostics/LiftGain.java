package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiftGain {
  @Id
  @SequenceGenerator(
          name = "lift_gain_sequence",
          sequenceName = "lift_gain_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "lift_gain_sequence"
  )
  @JsonIgnore
  private Long liftGainId;

  private Float zero;
  private Float one;
  private Float two;
  private Float three;
  private Float four;
  private Float five;
  private Float six;
  private Float seven;
  private Float eight;
  private Float nine;
  private Float ten;
  private Float eleven;
  private Float twelve;
  private Float thirteen;
  private Float fourteen;
  private Float fifteen;
  private Float sixteen;
  private Float seventeen;
  private Float eighteen;
  private Float nineteen;


}
