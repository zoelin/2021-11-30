package tw.com.fcb.mimosa.workshop.vaccine.crud.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Table(name="CRUD_RESIDENT")
@Entity
@Data
public class CrudResidentEntity {

  @Id
  @GeneratedValue
  Long id;

  String nhiNo;
  String phoneNo;

  @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
  @JoinColumn(name="resident_id")
  List<CrudChooseEntity> chooses;

  @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
  @JoinColumn(name="resident_id")
  List<CrudCancelEntity> cancels;
}
