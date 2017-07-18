import {NgModule} from "@angular/core";

import {PatientFormRoutingModule} from "./patient-form-routing.module";
import {PatientFormComponent} from "./patient-form.component";
import {PersonalDataComponent} from "./personal-data/personal-data.component";
import {AdmissionComponent} from "./admission/admission.component";
import {ComorbiditiesComponent} from "./comorbidities/comorbidities.component";
import {OperationComponent} from "./operation/operation.component";
import {ComplicationsComponent} from "./complications/complications.component";
import {ExaminationsComponent} from "./examinations/examinations.component";
import {FollowUpVisitComponent} from "./follow-up-visit/follow-up-visit.component";
import {TroponinsComponent} from "./troponins/troponins.component";
import {SharedModule} from "../../shared/shared.module";


@NgModule({
  imports: [
    SharedModule,
    PatientFormRoutingModule
  ],
  declarations: [
    PatientFormComponent,
    PersonalDataComponent,
    AdmissionComponent,
    ComorbiditiesComponent,
    OperationComponent,
    ComplicationsComponent,
    ExaminationsComponent,
    FollowUpVisitComponent,
    TroponinsComponent
  ]
})
export class PatientFormModule { }
