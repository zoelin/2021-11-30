package tw.com.fcb.mimosa.workshop.vaccine.ddd.repository;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name="CANCEL")
@Entity
@Data
public class CancelEntity {

  @Id
  @GeneratedValue
  Long id;

  LocalDateTime cancel_time;

  @Enumerated(EnumType.STRING)
  Vaccine vaccine;

}

