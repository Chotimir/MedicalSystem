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
import {AdmissionService} from "../../communication/services/form/admission.service";
import {ComorbiditiesService} from "../../communication/services/form/comorbidities.service";
import {ComplicationsService} from "../../communication/services/form/complications.service";
import {ExaminationsService} from "../../communication/services/form/examinations.service";
import {FollowUpVisitService} from "../../communication/services/form/follow-up-visit.service";
import {OperationService} from "../../communication/services/form/operation.service";
import {PersonalDataService} from "../../communication/services/form/personal-data.service";
import {TroponinsService} from "../../communication/services/form/troponins.service";


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
  ],
  providers: [
    AdmissionService,
    ComorbiditiesService,
    ComplicationsService,
    ExaminationsService,
    FollowUpVisitService,
    OperationService,
    PersonalDataService,
    TroponinsService
  ]
})
export class PatientFormModule { }
