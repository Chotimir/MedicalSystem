import { Injectable } from '@angular/core';
import {FormService} from "./form-service.service";
import {FollowUpVisit} from "../../model/follow-up-visit";

@Injectable()
export class FollowUpVisitService extends FormService<FollowUpVisit> {

  private url = '/follow-up-visit';

  getFollowUpVisit(patientId: string): Promise<FollowUpVisit> {
    return this.get(patientId + this.url);
  }

  updateFollowUpVisit(followUpVisit: FollowUpVisit, patientId: string) {
    this.update(followUpVisit, patientId + this.url);
  }

}
