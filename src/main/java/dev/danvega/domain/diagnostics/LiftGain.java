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

  private Long zero;
  private Long one;
  private Long two;
  private Long three;
  private Long four;
  private Long five;
  private Long six;
  private Long seven;
  private Long eight;
  private Long nine;
  private Long ten;
  private Long eleven;
  private Long twelve;
  private Long thirteen;
  private Long fourteen;
  private Long fifteen;
  private Long sixteen;
  private Long seventeen;
  private Long eighteen;
  private Long nineteen;

  @ManyToOne
  private DiagnosticsReport diagnosticsReport;

}
