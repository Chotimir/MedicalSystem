import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {OperationService} from "../../services/form/operation.service";
import {Operation} from "../../../model/operation";

@Injectable()
export class OperationResolver implements Resolve<Operation> {

  constructor(private operationService: OperationService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Operation> {
    return this.operationService.getOperation(route.parent.params['id']);
  }
}
