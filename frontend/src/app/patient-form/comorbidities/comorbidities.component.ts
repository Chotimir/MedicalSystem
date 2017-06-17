import {AfterViewChecked, AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';

import {ComorbiditiesService} from "../../services/comorbidities.service";
import {SelectField} from "../../model/select-field";

@Component({
  selector: 'app-comorbidities',
  templateUrl: './comorbidities.component.html',
  styleUrls: ['./comorbidities.component.css'],
  providers: [ComorbiditiesService]
})
export class ComorbiditiesComponent implements OnInit, AfterViewChecked, OnDestroy {

  comorbidities: SelectField[];

  constructor(private comorbiditiesService: ComorbiditiesService) { }

  getComorbidities(): void {
    this.comorbiditiesService.getComorbidities().then(comorbidities => this.comorbidities = comorbidities);
  }

  setSelected(comorbidityName: string, selected: string) {
    this.comorbidities.filter(c => c.name === comorbidityName).forEach(c => c.selected = selected);
  }

  ngOnInit() {
    this.getComorbidities();
  }

  ngAfterViewChecked() {
    if (this.comorbidities != null) {
      this.comorbidities.filter(c => c.selected != null).forEach(c => {
        (<HTMLSelectElement>document.getElementById(c.name)).value = c.selected;
      });
    }
  }

  ngOnDestroy() {
    this.comorbiditiesService.updateComorbidities(this.comorbidities);
  }

}
