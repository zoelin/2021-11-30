package tw.com.fcb.mimosa.workshop.vaccine.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tw.com.fcb.mimosa.workshop.vaccine.crud.CrudResidentMapper;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudResidentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.crud.web.CrudResidentDto;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CrudResidentService {
  final CrudResidentRepository repository;
  final CrudResidentMapper mapper;

  public long createResident(CrudResidentDto dto) {
    var entity = mapper.toEntity(dto);
    return repository.save(entity).getId();
  }

  /**
   * find 居民
   * if 手機有值, update 居民
   * loop 選擇疫苗
   * if exist in both UI and DB; do nothing
   * if exist only in UI; insert 疫苗選擇
   * if exist only in DB; delete 疫苗選擇
   * @param id
   * @param dto
   */
  public void updateResident(long id, CrudResidentDto dto) {
    var db = repository.findById(id).orElseThrow();
    if(StringUtils.hasText(dto.getPhoneNo())){
      db.setPhoneNo(dto.getPhoneNo());
    }
    var drop = db.getChooses().stream()
      .filter(dbChoose -> !dto.getChooses().contains(dbChoose.getVaccine()))
      .collect(Collectors.toList());
    db.getChooses().removeAll(drop);

    var cancels = drop.stream()
      .map(CrudChooseEntity::getVaccine)
      .map(mapper::toCancelEntity)
      .collect(Collectors.toList());
    db.getCancels().addAll(cancels);

    var append = dto.getChooses().stream()
      .filter(dtoChoose -> {
        return db.getChooses().stream()
          .map(CrudChooseEntity::getVaccine)
          .noneMatch(dtoChoose::equals);
      })
      .map(mapper::toChooseEntity)
      .collect(Collectors.toList());
    db.getChooses().addAll(append);

    repository.save(db);
  }
}
