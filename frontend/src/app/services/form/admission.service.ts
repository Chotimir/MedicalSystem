import { Injectable } from '@angular/core';

import {Admission} from "../../model/admission";
import {FormService} from "./form-service.service";

@Injectable()
export class AdmissionService extends FormService<Admission> {

  private url = '/admission';

  getAdmission(patientId: string): Promise<Admission> {
    return this.get(patientId + this.url);
  }

  updateAdmission(admission: Admission, patientId: string): void {
    this.update(admission, patientId + this.url);
  }

}
