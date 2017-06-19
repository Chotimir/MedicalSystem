import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PatientsService} from "../../services/patients.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @Input() patientID: string;

  constructor(private router: Router, private patientService: PatientsService) { }

  ngOnInit() {
  }

  navigateToPatient() {
    this.patientService.checkId(this.patientID).then(response => {
      if (response === true) {
        this.router.navigate(["/patientForm", this.patientID]);
      } else {
        // TODO
      }
    });
  }

}
