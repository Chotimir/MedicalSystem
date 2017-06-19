import {Component, OnDestroy, OnInit} from '@angular/core';
import {PersonalData} from "../../model/personal-data";
import {PersonalDataService} from "../../services/form/personal-data.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-personal-data',
  templateUrl: './personal-data.component.html',
  styleUrls: ['./personal-data.component.css'],
  providers: [PersonalDataService]
})
export class PersonalDataComponent implements OnInit, OnDestroy {

  patientId: string;
  personalData: PersonalData;

  constructor(private personalDataService: PersonalDataService, private route: ActivatedRoute) { }

  getPersonalData(): void {
    this.personalDataService.getPersonalData(this.patientId).then(personalData => this.personalData = personalData);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getPersonalData();
  }

  ngOnDestroy() {
    console.log(this.personalData);
    this.personalDataService.updatePersonalData(this.personalData, this.patientId);
  }

}
