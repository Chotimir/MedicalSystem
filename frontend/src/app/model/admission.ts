import {SelectField} from "./select-field";
export class Admission {
  admissionDate: Date;
  operationDate: Date;
  aorticAnurysmSymtoms: SelectField;
  aorticAneurysmSize: number;
  maxIliacAneurysmSize: number;
  imageExamination: SelectField;
  aneurysmLocation: SelectField;
  smoking: SelectField;
  asaScale: number;
  leeRcri: number;
  pPossum: number;
  faint: SelectField;
  comments: string;
}
