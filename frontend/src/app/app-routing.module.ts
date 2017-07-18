import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthGuard} from "./core/auth-guard/auth.guard";

const routes: Routes = [
  { path: 'auth', loadChildren: "./layout/auth/auth.module#AuthModule" },
  { path: 'home', loadChildren: "./layout/home/home.module#HomeModule", canActivate: [AuthGuard] },
  { path: 'patientForm/:id', loadChildren: "./layout/patient-form/patient-form.module#PatientFormModule", canActivate: [AuthGuard] },
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth', pathMatch: 'full' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
