import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import {FormsModule} from "@angular/forms";

import { PatientFormRoutingModule } from "./patient-form-routing.module";
import { PatientFormComponent } from './patient-form.component';
import { PersonalDataComponent } from "./personal-data/personal-data.component";
import { AdmissionComponent } from './admission/admission.component';
import { ComorbiditiesComponent } from './comorbidities/comorbidities.component';
import { OperationComponent } from './operation/operation.component';
import { ComplicationsComponent } from './complications/complications.component';
import { ExaminationsComponent } from './examinations/examinations.component';
import { FollowUpVisitComponent } from './follow-up-visit/follow-up-visit.component';
import { TroponinsComponent } from './troponins/troponins.component';


@NgModule({
  imports: [
    CommonModule,
    TranslateModule,
    PatientFormRoutingModule,
    FormsModule
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
