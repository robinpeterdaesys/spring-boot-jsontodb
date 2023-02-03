package com.robo.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ML_AI_MODEL_DIA_REP_LIFT_GAIN")
public class MlAiModelDiaRepLiftGainEntity {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MlAiModelDiaRepLiftGainEntity that = (MlAiModelDiaRepLiftGainEntity) o;

    return liftGainId.equals(that.liftGainId);
  }

  @Override
  public int hashCode() {
    return liftGainId.hashCode();
  }

  @ManyToOne(
          fetch = FetchType.LAZY
  )
  @JoinColumn(name = "ML_AI_MODEL_DIA_REPORT_ID")
  @JsonBackReference(value = "liftGain-diagnosticsReport")
  private MlAiModelDiaReportEntity diagnosticsReport;
}
