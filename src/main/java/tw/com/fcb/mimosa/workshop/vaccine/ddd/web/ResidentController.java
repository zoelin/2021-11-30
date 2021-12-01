package tw.com.fcb.mimosa.workshop.vaccine.ddd.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ResidentEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.service.ResidentService;

import java.util.List;

/**
 * 命令風格 API
 */
@RequiredArgsConstructor
@RequestMapping("/residents")
@RestController
class ResidentController {

  final ResidentService service;

  /**
   * 2021/11/30 homework
   */
  @PostMapping
  long makeAppointment(@RequestBody MakeAppointment command) {
    return service.makeAppointment(command);
  }

  @PutMapping("/{id}")
  void replaceResidentProfile(@PathVariable("id") long id,
                              @RequestBody ReplaceResidentProfile command) {
    service.replaceResidentProfile(id, command);
  }

  @PutMapping("/{id}/vaccines")
  void chooseVaccine(@PathVariable("id") long id,
                     @RequestBody ChooseVaccine command) {
    service.chooseVaccine(id, command);
  }

  @DeleteMapping("/{id}/vaccines")
  void cancelVaccine(@PathVariable("id") long id,
                     @RequestBody CancelVaccine command) {
    service.cancelVaccine(id, command);
  }
  /**
   * 2021/11/30 homework
   */
  @GetMapping
  List<ResidentEntity> getResidents() {
    return service.getResidents();
  }
}
