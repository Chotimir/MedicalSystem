import { Injectable } from '@angular/core';

import {FormService} from "./form-service.service";
import {PersonalData} from "../../model/personal-data";

@Injectable()
export class PersonalDataService extends FormService<PersonalData> {

  private url = '/personalData';

  getPersonalData(patientId: string): Promise<PersonalData> {
    return this.get(patientId + this.url);
  }

  updatePersonalData(personalData: PersonalData, patientId: string): void {
    this.update(personalData, patientId + this.url);
  }

}
