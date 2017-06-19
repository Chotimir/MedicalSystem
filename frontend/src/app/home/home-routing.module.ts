import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home.component";
import {SearchComponent} from "./search/search.component";
import {ImportComponent} from "./import/import.component";
import {AdminComponent} from "./admin/admin.component";
import {ExportComponent} from "./export/export.component";

export const routes: Routes = [
  {path: '', component: HomeComponent,
    children: [
      { path: 'search', component: SearchComponent },
      { path: 'import', component: ImportComponent },
      { path: 'export', component: ExportComponent },
      { path: 'admin', component: AdminComponent },
      { path: 'auth', redirectTo: '/auth/login', pathMatch: 'full'},
      { path: '', redirectTo: 'search', pathMatch: 'full'},
      { path: '**', redirectTo: 'search', pathMatch: 'full'},
    ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule {}
