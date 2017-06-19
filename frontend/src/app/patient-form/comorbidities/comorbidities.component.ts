import {Component, OnDestroy, OnInit} from '@angular/core';

import {ComorbiditiesService} from "../../services/comorbidities.service";
import {SelectField} from "../../model/select-field";

@Component({
  selector: 'app-comorbidities',
  templateUrl: './comorbidities.component.html',
  styleUrls: ['./comorbidities.component.css'],
  providers: [ComorbiditiesService]
})
export class ComorbiditiesComponent implements OnInit, OnDestroy {

  comorbidities: SelectField[];

  constructor(private comorbiditiesService: ComorbiditiesService) { }

  getComorbidities(): void {
    this.comorbiditiesService.getComorbidities().then(comorbidities => this.comorbidities = comorbidities);
  }

  ngOnInit() {
    this.getComorbidities();
  }

  ngOnDestroy() {
    console.log(this.comorbidities);
    this.comorbiditiesService.updateComorbidities(this.comorbidities);
  }

}
