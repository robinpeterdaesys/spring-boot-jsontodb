package dev.danvega.domain.diagnostics;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//  @OneToMany(
//          cascade = CascadeType.ALL,
//          orphanRemoval = true
//  )
//  @JoinColumn(name = "liftGainId")
//  private List<SemiDecile> semiDeciles = new ArrayList<>();
//  private Map<String,Integer> semiDecile = new HashMap<>();
//  private List<Integer> numberOfEvents = new ArrayList<Integer>();
//  private List<Integer> numberOfPositiveEvents = new ArrayList<Integer>();
//  private List<Integer> maxPossibleNumberOfPositiveEvents = new ArrayList<Integer>();
}
