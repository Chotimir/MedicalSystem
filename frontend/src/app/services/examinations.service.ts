import {Injectable} from "@angular/core";

import {FormService} from "./form-service.service";
import {Examination} from "../model/examination";

@Injectable()
export class ExaminationsService extends FormService<Examination[]> {

  private url = '/examinations';

  getExaminations(patientId: string): Promise<Examination[]> {
    return this.get(patientId + this.url);
  }

  updateExaminations(tests: Examination[], patientId: string): void {
    this.update(tests, patientId + this.url);
  }

}
