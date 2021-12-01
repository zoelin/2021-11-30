package tw.com.fcb.mimosa.workshop.vaccine.crud.web;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.util.List;

@Data
public class CrudResidentDto {

  String nhiNo;
  String phoneNo;
  List<Vaccine> chooses;


}
