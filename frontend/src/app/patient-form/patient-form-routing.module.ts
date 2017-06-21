import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PatientFormComponent } from './patient-form.component';
import { PersonalDataComponent } from "./personal-data/personal-data.component";
import {AdmissionComponent} from "./admission/admission.component";
import {ExaminationsComponent} from "./examinations/examinations.component";
import {ComorbiditiesComponent} from "./comorbidities/comorbidities.component";
import {OperationComponent} from "./operation/operation.component";
import {ComplicationsComponent} from "./complications/complications.component";

export const routes: Routes = [
  {path: '', component: PatientFormComponent,
  children: [
    { path: "personalData", component: PersonalDataComponent },
    { path: "admission", component: AdmissionComponent },
    { path: "tests", component: ExaminationsComponent },
    { path: "comorbidities", component: ComorbiditiesComponent },
    { path: "followUpVisit", component: OperationComponent },
    { path: "complications", component: ComplicationsComponent },
    { path: 'home', redirectTo: '/home/patients', pathMatch: 'full'},
    { path: '', redirectTo: 'personalData', pathMatch: 'full'},
    { path: '**', redirectTo: 'personalData', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class PatientFormRoutingModule {}
