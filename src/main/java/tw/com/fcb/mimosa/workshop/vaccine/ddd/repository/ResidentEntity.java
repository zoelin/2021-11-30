package tw.com.fcb.mimosa.workshop.vaccine.ddd.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Table(name="RESIDENT")
@Entity
@Data
public class ResidentEntity {

  @Id
  @GeneratedValue
  Long id;

  String nhiNo;
  String phoneNo;

  @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
  @JoinColumn(name="resident_id")
  List<ChooseEntity> chooses;

  @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
  @JoinColumn(name="resident_id")
  List<CancelEntity> cancels;
}
