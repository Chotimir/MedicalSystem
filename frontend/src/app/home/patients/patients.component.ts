import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PatientsService} from "../../services/patients.service";

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css'],
  providers: [PatientsService]
})
export class PatientsComponent implements OnInit {

  @Input()
  patientID: string;
  creationMode: boolean;

  constructor(private router: Router, private patientsService: PatientsService) { }

  ngOnInit() {
  }

  performAction() {
    if (this.creationMode) {
      this.createPatient();
    } else {
      this.navigateToPatient();
    }
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

  navigateToPatient() {
    this.patientsService.checkId(this.patientID).then(exists => {
      if (exists === true) {
        this.router.navigate(["/patientForm", this.patientID]);
      } else {
        // TODO alert
      }
    });
  }

  chooseSearch() {
    this.creationMode = false;
  }

  chooseCreate() {
    this.creationMode = true;
  }

}
