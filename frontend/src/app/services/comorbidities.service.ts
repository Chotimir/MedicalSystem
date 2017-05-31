import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { BooleanField } from "../model/boolean-field";

const mockdata: BooleanField[] = [
  { name: "choroba 1", value: false },
  { name: "choroba 2", value: true },
  { name: "choroba 3", value: false },
  { name: "choroba 4", value: false },
  { name: "choroba 5", value: true }
];

@Injectable()
export class ComorbiditiesService {

  private comorbiditiesUrl = 'api/comorbidities';

  constructor(private http: Http) { }

  getComorbidities(): Promise<BooleanField[]> {
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
