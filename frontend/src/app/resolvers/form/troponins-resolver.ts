import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Troponins} from "../../model/troponins";
import {TroponinsService} from "../../services/form/troponins.service";

@Injectable()
export class TroponinsResolver implements Resolve<Troponins> {

  constructor(private troponinsService: TroponinsService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Troponins> {
    return this.troponinsService.getTroponins(route.parent.params['id']);
  }
}
