import {SelectField} from "./select-field";

export class Operation {
  operationMode: SelectField;
  anesthesia: SelectField;
  anesthetic: SelectField;
  duration: number;
  aortaClottingTime: number;
  noradrenaline: boolean;
  dopamine: boolean;
  dobutamine: boolean;
  ephedrine: boolean;
  bloodLost: number;
  urineExpelled: number;
  packedCellsTransfused: number;
  icuTime: number;
  hospitalTime: number;
  extendedVentilation: boolean;
  ventilatorDays: number;
}
