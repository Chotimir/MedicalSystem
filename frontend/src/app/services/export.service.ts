import {Injectable} from '@angular/core';
import {Http, RequestOptions, ResponseContentType} from "@angular/http";

@Injectable()
export class ExportService {

  private exportUrl = 'api/export';

  constructor(private http: Http) { }

  exportExcel(): Promise<Blob> {
    const options = new RequestOptions({responseType: ResponseContentType.Blob });
    return this.http.get(this.exportUrl, options).toPromise()
      .then(res => res.blob() as Blob)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
