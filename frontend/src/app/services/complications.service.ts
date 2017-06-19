import { Injectable } from '@angular/core';

import {SelectField} from "../model/select-field";
import {FormService} from "./form-service.service";

@Injectable()
export class ComplicationsService extends FormService<SelectField[]> {

  private complicationsUrl = 'api/complications';

  getComplications(): Promise<SelectField[]> {
    return this.get(this.complicationsUrl);
  }

  updateComplications(complications: SelectField[]): void {
    this.update(complications, this.complicationsUrl);
  }

}
