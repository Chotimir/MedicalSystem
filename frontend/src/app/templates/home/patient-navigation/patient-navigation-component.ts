import {Component, Input, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {PatientsService} from "../../../communication/services/patients.service";

@Component({
  providers: [PatientsService]
})
export abstract class PatientNavigationComponent implements OnInit {

  @Input()
  patientID: string;

  constructor(protected router: Router, protected patientsService: PatientsService) { }

  ngOnInit() {}

  navigateToPatient() {
    this.patientsService.checkId(this.patientID).then(exists => {
      if (exists === true) {
        this.router.navigate(["/patientForm", this.patientID]);
      } else {
        // TODO alert
      }
    });
  }
}
