import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions, ResponseContentType} from "@angular/http";
import {AuthService} from "./auth.service";

@Injectable()
export class ExportService {

  private headers = new Headers({'Authorization': AuthService.getToken()});
  private exportUrl = 'api/export';

  constructor(private http: Http) { }

  exportExcel(): Promise<Blob> {
    const options = new RequestOptions({responseType: ResponseContentType.Blob, headers: this.headers});
    return this.http.get(this.exportUrl, options).toPromise()
      .then(res => res.blob() as Blob)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
