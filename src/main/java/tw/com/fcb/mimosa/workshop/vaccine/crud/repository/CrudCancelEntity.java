package tw.com.fcb.mimosa.workshop.vaccine.crud.repository;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name="CRUD_CANCEL")
@Entity
@Data
public class CrudCancelEntity {

  @Id
  @GeneratedValue
  Long id;

  LocalDateTime cancel_time;

  @Enumerated(EnumType.STRING)
  Vaccine vaccine;

}

