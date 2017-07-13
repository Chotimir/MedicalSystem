import { Injectable } from '@angular/core';
import {Http} from "@angular/http";

@Injectable()
export class PatientsService {

  private patientsUrl = 'api/patients/';

  constructor(private http: Http) { }

  checkId(patientId: string): Promise<boolean> {
    return this.http.get(this.patientsUrl + patientId).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  createPatient(patientId: string): Promise<boolean> {
    return this.http.post(this.patientsUrl + patientId, "").toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
