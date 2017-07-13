import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home.component";
import {PatientsComponent} from "./patients/patients.component";
import {ImportComponent} from "./import/import.component";
import {AdminComponent} from "./admin/admin.component";
import {ExportComponent} from "./export/export.component";
import {AuthGuard} from "../auth/auth-guard/auth.guard";
import {AdminAuthGuard} from "../auth/auth-guard/admin-auth.guard";

export const routes: Routes = [
  {path: '', component: HomeComponent,
    children: [
      { path: 'patients', component: PatientsComponent, canActivate: [AuthGuard] },
      { path: 'import', component: ImportComponent, canActivate: [AuthGuard] },
      { path: 'export', component: ExportComponent, canActivate: [AdminAuthGuard] },
      { path: 'admin', component: AdminComponent, canActivate: [AdminAuthGuard] },
      { path: 'auth', redirectTo: '/auth/login', pathMatch: 'full'},
      { path: '', redirectTo: 'patients', pathMatch: 'full'},
      { path: '**', redirectTo: 'patients', pathMatch: 'full'}
    ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule {}
