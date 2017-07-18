import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {FollowUpVisitService} from "../../services/form/follow-up-visit.service";
import {FollowUpVisit} from "../../../model/follow-up-visit";

@Injectable()
export class FollowUpVisitResolver implements Resolve<FollowUpVisit> {

  constructor(private followUpVisitService: FollowUpVisitService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<FollowUpVisit> {
    return this.followUpVisitService.getFollowUpVisit(route.parent.params['id']);
  }
}
