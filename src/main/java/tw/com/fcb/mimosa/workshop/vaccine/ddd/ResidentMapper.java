package tw.com.fcb.mimosa.workshop.vaccine.ddd;

import org.mapstruct.Mapper;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.CancelEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.time.LocalDateTime;

@Mapper
public interface ResidentMapper {
  //CrudResidentEntity toEntity (CrudResidentDto dto );

  default ChooseEntity toChooseEntity(Vaccine vaccine){
    var entity = new ChooseEntity();
    entity.setChoose_time(LocalDateTime.now());
    entity.setVaccine(vaccine);
    return entity;
  }

  default CancelEntity toCancelEntity(Vaccine vaccine){
    var entity = new CancelEntity();
    entity.setCancel_time(LocalDateTime.now());
    entity.setVaccine(vaccine);
    return entity;
  }
}
