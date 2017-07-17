import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./templates/auth/auth-guard/auth.guard";

const routes: Routes = [
  { path: 'home', loadChildren: "./home/home.module#HomeModule", canActivate: [AuthGuard] },
  { path: 'auth', loadChildren: "./auth/auth.module#AuthModule" },
  { path: 'patientForm/:id', loadChildren: "./patient-form/patient-form.module#PatientFormModule", canActivate: [AuthGuard] },
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
