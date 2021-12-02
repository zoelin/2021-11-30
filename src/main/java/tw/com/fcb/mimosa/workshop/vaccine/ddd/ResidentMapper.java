package tw.com.fcb.mimosa.workshop.vaccine.ddd;

import org.mapstruct.Mapper;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.CancelEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ResidentEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.ResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.time.LocalDateTime;

@Mapper
public interface ResidentMapper {
  ResidentEntity toEntity (MakeAppointment command );

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

  ResidentProfile fromEntity(ResidentEntity residentEntity);

  default Vaccine toChooseEntity( ChooseEntity entity){
    return entity.getVaccine();
  }
}
