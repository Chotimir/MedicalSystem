import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/patientForm', pathMatch: 'full' },
  { path: 'patientForm', loadChildren: "./patient-form/patient-form.module#PatientFormModule" }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
