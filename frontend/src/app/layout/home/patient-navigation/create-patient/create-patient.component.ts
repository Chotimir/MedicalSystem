import {Component, Input} from "@angular/core";
import {PatientsService} from "../../../../core/services/patients.service";
import {Router} from "@angular/router";
import {PatientNavigationComponent} from "../patient-navigation-component";

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css'],
  providers: [PatientsService]
})
export class CreatePatientComponent extends PatientNavigationComponent {

  @Input()
  patientID: string;

  constructor(router: Router, patientsService: PatientsService) {
    super(router, patientsService);
  }

  createPatient() {
    this.patientsService.checkId(this.patientID).then(exists => {
      if (exists === false) {
        this.patientsService.createPatient(this.patientID).
        then(() => this.navigateToPatient());
      } else {
        // TODO alert
      }
    });
  }

}
