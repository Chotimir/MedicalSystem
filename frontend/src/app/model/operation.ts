import {SelectField} from "./select-field";

export class Operation {
  operationMode: SelectField;
  anesthesia: SelectField;
  anesthetic: SelectField;
  duration: number;
  aortaClottingTime: number;
  noradrenaline: SelectField;
  dopamine: SelectField;
  dobutamine: SelectField;
  ephedrine: SelectField;
  bloodLost: number;
  urineExpelled: number;
  packedCellsTransfused: number;
  icuTime: number;
  hospitalYime: number;
  extendedVentilation: SelectField;
  ventilatorDays: number;
}
