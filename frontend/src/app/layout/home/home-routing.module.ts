import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home.component";
import {PatientSearchComponent} from "./patient-navigation/patient-search/patient-search.component";
import {CreatePatientComponent} from "./patient-navigation/create-patient/create-patient.component";
import {ImportComponent} from "./import/import.component";
import {AdminComponent} from "./admin/admin.component";
import {ExportComponent} from "./export/export.component";
import {AuthGuard} from "../../core/auth-guard/auth.guard";
import {AdminAuthGuard} from "../../core/auth-guard/admin-auth.guard";

export const routes: Routes = [
  {path: '', component: HomeComponent,
    children: [
      { path: 'patient-search', component: PatientSearchComponent, canActivate: [AuthGuard] },
      { path: 'create-patient', component: CreatePatientComponent, canActivate: [AuthGuard] },
      { path: 'import', component: ImportComponent, canActivate: [AuthGuard] },
      { path: 'export', component: ExportComponent, canActivate: [AdminAuthGuard] },
      { path: 'admin', component: AdminComponent, canActivate: [AdminAuthGuard] },
      { path: 'auth', redirectTo: '/auth/login', pathMatch: 'full'},
      { path: '', redirectTo: 'patient-search', pathMatch: 'full'},
      { path: '**', redirectTo: 'patient-search', pathMatch: 'full'}
    ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule {}
