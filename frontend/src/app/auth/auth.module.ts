import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthComponent } from './auth.component';
import {AuthRoutingModule} from "./auth-routing.module";
import {TranslateModule} from "@ngx-translate/core";

@NgModule({
  imports: [
    CommonModule,
    AuthRoutingModule,
    TranslateModule
  ],
  declarations: [LoginComponent, RegistrationComponent, AuthComponent]
})
export class AuthModule { }
