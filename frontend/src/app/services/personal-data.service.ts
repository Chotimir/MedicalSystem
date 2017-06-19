import { Injectable } from '@angular/core';

import {FormService} from "./form-service.service";
import {PersonalData} from "../model/personal-data";

@Injectable()
export class PersonalDataService extends FormService<PersonalData> {

  private personalDataUrl = 'api/personalData';

  getPersonalData(): Promise<PersonalData> {
    return this.get(this.personalDataUrl);
  }

  updatePersonalData(personalData: PersonalData): void {
    this.update(personalData, this.personalDataUrl);
  }

}
