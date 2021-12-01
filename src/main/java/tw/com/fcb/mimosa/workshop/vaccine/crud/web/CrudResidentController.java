package tw.com.fcb.mimosa.workshop.vaccine.crud.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.workshop.vaccine.crud.service.CrudResidentService;

/**
 * CRUD 風格 API
 */
@RequiredArgsConstructor
@RequestMapping("/crud/residents")
@RestController
class CrudResidentController {

  final CrudResidentService service;

  @GetMapping
  void getResident() {

  }

  @PostMapping
  long createResident(@RequestBody CrudResidentDto dto) {
    return service.createResident(dto);
  }

  @PutMapping("/{id}")
  void updateResident(@PathVariable("id") long id,@RequestBody CrudResidentDto dto) {
    service.updateResident(id,dto);
  }

}
