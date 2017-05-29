import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PatientFormComponent } from './patient-form.component';
import { PersonalDataComponent } from "./personal-data/personal-data.component";

export const routes: Routes = [
  {path: '', component: PatientFormComponent,
  children: [
    { path: "personalData", component: PersonalDataComponent },
    { path: 'home', redirectTo: '/home/search', pathMatch: 'full'},
    { path: '', redirectTo: 'personalData', pathMatch: 'full'},
    { path: '**', redirectTo: 'personalData', pathMatch: 'full'}
  ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class PatientFormRoutingModule {}
