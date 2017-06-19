import { Injectable } from '@angular/core';

import {FormService} from "./form-service.service";
import {Operation} from "../model/operation";

@Injectable()
export class OperationService extends FormService<Operation> {

  private operationUrl = 'api/operation';

  getOperation(): Promise<Operation> {
    return this.get(this.operationUrl);
  }

  updateOperation(operation: Operation): void {
    this.update(operation, this.operationUrl);
  }

}
