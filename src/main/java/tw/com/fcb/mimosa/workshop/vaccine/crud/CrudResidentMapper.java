package tw.com.fcb.mimosa.workshop.vaccine.crud;

import org.mapstruct.Mapper;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudCancelEntity;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudResidentEntity;
import tw.com.fcb.mimosa.workshop.vaccine.crud.web.CrudResidentDto;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.time.LocalDateTime;

@Mapper
public interface CrudResidentMapper {
  CrudResidentEntity toEntity (CrudResidentDto dto );

  default CrudChooseEntity toChooseEntity(Vaccine vaccine){
    var entity = new CrudChooseEntity();
    entity.setChoose_time(LocalDateTime.now());
    entity.setVaccine(vaccine);
    return entity;
  }

  default CrudCancelEntity toCancelEntity(Vaccine vaccine){
    var entity = new CrudCancelEntity();
    entity.setCancel_time(LocalDateTime.now());
    entity.setVaccine(vaccine);
    return entity;
  }
}
