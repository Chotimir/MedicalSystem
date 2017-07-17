import { Injectable } from '@angular/core';
import {Headers, Http} from "@angular/http";
import {AuthService} from "./auth.service";

@Injectable()
export class PatientsService {

  private headers = new Headers({'Content-Type': 'application/json', 'Authorization': AuthService.getToken()});
  private patientsUrl = 'api/patients/';

  constructor(private http: Http) { }

  checkId(patientId: string): Promise<boolean> {
    return this.http.get(this.patientsUrl + patientId, {headers: this.headers}).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  createPatient(patientId: string): Promise<boolean> {
    return this.http.post(this.patientsUrl + patientId, "", {headers: this.headers}).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
