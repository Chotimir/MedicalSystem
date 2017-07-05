import { Injectable } from '@angular/core';

import {FormService} from "./form-service.service";
import {Operation} from "../../model/operation";

@Injectable()
export class OperationService extends FormService<Operation> {

  private url = '/operation';

  getOperation(patientId: string): Promise<Operation> {
    return this.get(patientId + this.url);
  }

  updateOperation(operation: Operation, patientId: string) {
    this.update(operation, patientId + this.url);
  }

}
