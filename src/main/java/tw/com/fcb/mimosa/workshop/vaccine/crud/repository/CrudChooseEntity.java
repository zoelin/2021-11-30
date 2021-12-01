package tw.com.fcb.mimosa.workshop.vaccine.crud.repository;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name="CRUD_CHOOSE")
@Entity
@Data
public class CrudChooseEntity {

  @Id
  @GeneratedValue
  Long id;

  LocalDateTime choose_time;

  @Enumerated(EnumType.STRING)
  Vaccine vaccine;
}
