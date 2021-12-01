package tw.com.fcb.mimosa.workshop.vaccine.ddd.repository;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name="CHOOSE")
@Entity
@Data
public class ChooseEntity {

  @Id
  @GeneratedValue
  Long id;

  LocalDateTime choose_time;

  @Enumerated(EnumType.STRING)
  Vaccine vaccine;
}
