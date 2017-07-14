import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {PersonalData} from "../../model/personal-data";
import {PersonalDataService} from "../../services/form/personal-data.service";

@Injectable()
export class PersonalDataResolver implements Resolve<PersonalData> {

  constructor(private personalDataService: PersonalDataService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<PersonalData> {
    return this.personalDataService.getPersonalData(route.parent.params['id']);
  }
}
