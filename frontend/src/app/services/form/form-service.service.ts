import {Headers, Http} from "@angular/http";
import {Injectable} from "@angular/core";
import {AuthService} from "app/services/auth.service";

@Injectable()
export abstract class FormService<T> {

  private headers = new Headers({'Content-Type': 'application/json', 'Authorization': AuthService.getToken()});
  private patientsUrl = 'api/patient-search/';

  constructor(private http: Http) { }

  get(childUrl: string): Promise<T> {
    return this.http.get(this.patientsUrl + childUrl, {headers: this.headers})
      .toPromise().then(response => response.json() as T)
      .catch(this.handleError);
  }

  update(data: T, childUrl: string) {
    this.http.put(this.patientsUrl + childUrl, JSON.stringify(data), {headers: this.headers})
      .toPromise().catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
