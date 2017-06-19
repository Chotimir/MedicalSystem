import { Injectable } from '@angular/core';

import {SelectField} from "../model/select-field";
import {FormService} from "./form-service.service";

@Injectable()
export class ComplicationsService extends FormService<SelectField[]> {

  private url = '/complications';

  getComplications(patientId: string): Promise<SelectField[]> {
    return this.get(patientId + this.url);
  }

  updateComplications(complications: SelectField[], patientId: string): void {
    this.update(complications, patientId + this.url);
  }

}
