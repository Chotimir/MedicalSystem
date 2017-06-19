import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'home', loadChildren: "./home/home.module#HomeModule" },
  { path: 'auth', loadChildren: "./auth/auth.module#AuthModule" },
  { path: 'patientForm', loadChildren: "./patient-form/patient-form.module#PatientFormModule" },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
