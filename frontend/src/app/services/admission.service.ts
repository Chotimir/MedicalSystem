import { Injectable } from '@angular/core';

import {Admission} from "../model/admission";
import {FormService} from "./form-service.service";

@Injectable()
export class AdmissionService extends FormService {

  private admissionUrl = 'api/admission';

  getAdmission(): Promise<Admission> {
    return this.get(this.admissionUrl);
  }

  updateAdmission(admission: Admission): void {
    this.update(admission, this.admissionUrl);
  }

}
