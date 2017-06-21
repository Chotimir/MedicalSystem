import {SelectField} from "./select-field";
export class Admission {
  admissionDate: Date;
  operationDate: Date;
  operationType: SelectField;
  aorticAneurysmSymptoms: SelectField;
  aorticAneurysmSize: number;
  maxIliacAneurysmSize: number;
  imagingExamination: SelectField;
  aneurysmLocation: SelectField;
  smoking: SelectField;
  asaScale: SelectField;
  leeRcri: SelectField;
  pPossum: SelectField;
  unconsciousness: SelectField;
  reoperation: SelectField;
  comments: string;
}
