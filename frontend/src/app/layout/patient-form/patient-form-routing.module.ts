import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

import {PatientFormComponent} from "./patient-form.component";
import {PersonalDataComponent} from "./personal-data/personal-data.component";
import {AdmissionComponent} from "./admission/admission.component";
import {ExaminationsComponent} from "./examinations/examinations.component";
import {ComorbiditiesComponent} from "./comorbidities/comorbidities.component";
import {OperationComponent} from "./operation/operation.component";
import {ComplicationsComponent} from "./complications/complications.component";
import {FollowUpVisitComponent} from "./follow-up-visit/follow-up-visit.component";
import {TroponinsComponent} from "./troponins/troponins.component";
import {PersonalDataResolver} from "../../core/resolvers/form/personal-data-resolver";
import {AdmissionResolver} from "../../core/resolvers/form/admission-resolver";
import {FollowUpVisitResolver} from "../../core/resolvers/form/follow-up-visit-resolver";
import {TroponinsResolver} from "../../core/resolvers/form/troponins-resolver";
import {OperationResolver} from "../../core/resolvers/form/operation-resolver";

export const routes: Routes = [
  {
    path: '', component: PatientFormComponent,
    children: [
      {path: "personalData", component: PersonalDataComponent, resolve: {personalData: PersonalDataResolver}},
      {path: "admission", component: AdmissionComponent, resolve: {admission: AdmissionResolver}},
      {path: "troponins", component: TroponinsComponent, resolve: {troponins: TroponinsResolver}},
      {path: "operation", component: OperationComponent, resolve: {operation: OperationResolver}},
      {path: "follow-up", component: FollowUpVisitComponent, resolve: {followUpVisit: FollowUpVisitResolver}},
      {path: "complications", component: ComplicationsComponent},
      {path: "examinations", component: ExaminationsComponent},
      {path: "comorbidities", component: ComorbiditiesComponent},
      {path: 'home', redirectTo: '/home/patient-search', pathMatch: 'full'},
      {path: '', redirectTo: 'personalData', pathMatch: 'full'},
      {path: '**', redirectTo: 'personalData', pathMatch: 'full'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [
    AdmissionResolver,
    FollowUpVisitResolver,
    OperationResolver,
    PersonalDataResolver,
    TroponinsResolver
  ]
})
export class PatientFormRoutingModule {
}
