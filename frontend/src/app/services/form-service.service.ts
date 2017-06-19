import {Headers, Http} from "@angular/http";
import {Injectable} from "@angular/core";

@Injectable()
export abstract class FormService<T> {

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) { }

  get(serviceUrl: string): Promise<T> {
    return this.http.get(serviceUrl).toPromise()
      .then(response => response.json() as T)
      .catch(this.handleError);
  }

  update(data: T, serviceUrl: string): void {
    this.http.put(serviceUrl, JSON.stringify(data), {headers: this.headers})
      .toPromise()
      .then(() => "")
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
