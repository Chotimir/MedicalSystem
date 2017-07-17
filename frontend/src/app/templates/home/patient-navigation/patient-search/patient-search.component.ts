import {Component, Input} from "@angular/core";
import {Router} from "@angular/router";
import {PatientsService} from "../../../../communication/services/patients.service";
import {PatientNavigationComponent} from "../patient-navigation-component";

@Component({
  selector: 'app-patients',
  templateUrl: './patient-search.component.html',
  styleUrls: ['./patient-search.component.css'],
  providers: [PatientsService]
})
export class PatientSearchComponent extends PatientNavigationComponent {

  @Input()
  patientID: string;

  constructor(router: Router, patientsService: PatientsService) {
    super(router, patientsService);
  }
}
