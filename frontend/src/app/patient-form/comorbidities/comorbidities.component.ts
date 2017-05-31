import { Component, OnInit } from '@angular/core';
import {ComorbiditiesService} from "../../services/comorbidities.service";
import {BooleanField} from "../../model/boolean-field";

@Component({
  selector: 'app-comorbidities',
  templateUrl: './comorbidities.component.html',
  styleUrls: ['./comorbidities.component.css'],
  providers: [ComorbiditiesService]
})
export class ComorbiditiesComponent implements OnInit {

  comorbidities: BooleanField[];

  constructor(private comorbiditiesService: ComorbiditiesService) { }

  getComorbidities(): void {
    this.comorbiditiesService.getComorbidities().then(comorbidities => this.comorbidities = comorbidities);
  }

  ngOnInit() {
    this.getComorbidities();
  }

}
