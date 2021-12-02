package tw.com.fcb.mimosa.workshop.vaccine.ddd.web;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

import java.util.List;

@Data
public class ResidentProfile {
  String nhiNo;
  String phoneNo;
  List<Vaccine> chooses;

}
