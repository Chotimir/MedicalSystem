import {Injectable} from "@angular/core";

import {FormService} from "./form-service.service";
import {Examination} from "../model/examination";

@Injectable()
export class ExaminationService extends FormService<Examination[]> {

  private examinationUrl = 'api/examinations';

  getTests(): Promise<Examination[]> {
    return this.get(this.examinationUrl);
  }

  updateTests(tests: Examination[]): void {
    this.update(tests, this.examinationUrl);
  }

}
