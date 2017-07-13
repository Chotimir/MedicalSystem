import {Injectable} from "@angular/core";
import {Troponins} from "../../model/troponins";
import {FormService} from "../form-service.service";

@Injectable()
export class TroponinsService extends FormService<Troponins> {

  private url = '/operation';

  getTroponins(patientId: string): Promise<Troponins> {
    return this.get(patientId + this.url);
  }

  updateTroponins(troponins: Troponins, patientId: string) {
    this.update(troponins, patientId + this.url);
  }

}
