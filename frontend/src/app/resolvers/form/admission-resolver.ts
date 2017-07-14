import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {AdmissionService} from "../../services/form/admission.service";
import {Admission} from "../../model/admission";

@Injectable()
export class AdmissionResolver implements Resolve<Admission> {

  constructor(private admissionService: AdmissionService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Admission> {
    return this.admissionService.getAdmission(route.parent.params['id']);
  }
}
