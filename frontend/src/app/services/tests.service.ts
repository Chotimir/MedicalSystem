import { Injectable } from '@angular/core';

import {FormService} from "./form-service.service";
import {Tests} from "../model/tests";

@Injectable()
export class TestsService extends FormService {

  private testsUrl = 'api/tests';

  getTests(): Promise<Tests> {
    return this.get(this.testsUrl);
  }

  updateTests(tests: Tests): void {
    this.update(tests, this.testsUrl);
  }

}
