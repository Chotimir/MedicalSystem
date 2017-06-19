import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';

import {SelectField} from "../model/select-field";
import {FormService} from "./form-service.service";

@Injectable()
export class ComorbiditiesService extends FormService<SelectField[]> {

  private comorbiditiesUrl = 'api/comorbidities';

  getComorbidities(): Promise<SelectField[]> {
    return this.get(this.comorbiditiesUrl);
  }

  updateComorbidities(comorbidities: SelectField[]): void {
    this.update(comorbidities, this.comorbiditiesUrl);
  }

}
