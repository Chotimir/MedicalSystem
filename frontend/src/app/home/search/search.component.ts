import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @Input() patientID: string;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateToPatient() {
    this.router.navigate(["/patientForm", this.patientID]);
  }

}
