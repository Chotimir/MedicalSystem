import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import {SelectField} from "../model/select-field";

const mockdata: SelectField[] = [
  { name: "choroba 1", values: ["tak", "nie", "nwm"], selected: null},
  { name: "choroba 2", values: ["tak", "nie", "nwm"], selected: null },
  { name: "choroba 3", values: ["tak", "nie", "nwm"], selected: "tak" },
  { name: "choroba 4", values: ["tak", "nie", "nwm"], selected: "nie" },
  { name: "choroba 5", values: ["tak", "nie", "nwm"], selected: "nwm" }
];

@Injectable()
export class ComorbiditiesService {

  private comorbiditiesUrl = 'api/comorbidities';

  constructor(private http: Http) { }

  getComorbidities(): Promise<SelectField[]> {
    return Promise.resolve(mockdata);
    /*
    return this.http.get(this.comorbiditiesUrl).toPromise()
      .then(response => response.json() as BooleanField[])
      .catch(this.handleError);
     */
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
