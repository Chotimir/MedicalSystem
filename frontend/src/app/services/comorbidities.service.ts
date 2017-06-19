import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';

import {SelectField} from "../model/select-field";
import {FormService} from "./form-service.service";

const mockdata: SelectField[] = [
  { name: "choroba 1", values: ["tak", "nie", "nwm"], selected: null},
  { name: "choroba 2", values: ["tak", "nie", "nwm"], selected: null },
  { name: "choroba 3", values: ["tak", "nie", "nwm"], selected: "tak" },
  { name: "choroba 4", values: ["tak", "nie", "nwm"], selected: "nie" },
  { name: "choroba 5", values: ["tak", "nie", "nwm"], selected: "nwm" }
];

@Injectable()
export class ComorbiditiesService extends FormService<SelectField[]> {

  private comorbiditiesUrl = 'api/comorbidities';

  getComorbidities(): Promise<SelectField[]> {
    return Promise.resolve(mockdata);
    // return this.get(this.comorbiditiesUrl);
  }

  updateComorbidities(comorbidities: SelectField[]): void {
    // this.update(comorbidities, this.comorbiditiesUrl);
  }

}
