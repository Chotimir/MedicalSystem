import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {ComorbiditiesService} from "../../../communication/services/form/comorbidities.service";
import {SelectField} from "../../../model/select-field";

@Component({
  selector: 'app-comorbidities',
  templateUrl: './comorbidities.component.html',
  styleUrls: ['./comorbidities.component.css']
})
export class ComorbiditiesComponent implements OnInit, OnDestroy {

  patientId: string;
  comorbidities: SelectField[];

  constructor(private comorbiditiesService: ComorbiditiesService, private route: ActivatedRoute) { }

  getComorbidities() {
    this.comorbiditiesService.getComorbidities(this.patientId).then(comorbidities => this.comorbidities = comorbidities);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getComorbidities();
  }

  ngOnDestroy() {
    console.log(this.comorbidities);
    this.comorbiditiesService.updateComorbidities(this.comorbidities, this.patientId);
  }

}
