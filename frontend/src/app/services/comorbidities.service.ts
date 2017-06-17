import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import {SelectField} from "../model/select-field";

@Injectable()
export class ComorbiditiesService {

  private comorbiditiesUrl = 'api/comorbidities';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  getComorbidities(): Promise<SelectField[]> {
    return this.http.get(this.comorbiditiesUrl).toPromise()
      .then(response => response.json() as SelectField[])
      .catch(this.handleError);
  }

  updateComorbidities(comorbidities: SelectField[]): void {
    this.http.put(this.comorbiditiesUrl, JSON.stringify(comorbidities), {headers: this.headers})
      .toPromise()
      .then(() => "")
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
