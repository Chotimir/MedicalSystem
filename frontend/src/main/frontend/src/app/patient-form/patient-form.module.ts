import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientFormComponent } from './patient-form.component';
import { TranslateModule } from '@ngx-translate/core';

import {PatientFormRoutingModule} from "./patient-form-routing.module";

@NgModule({
  imports: [
    CommonModule,
    TranslateModule,
    PatientFormRoutingModule
  ],
  declarations: [PatientFormComponent]
})
export class PatientFormModule { }
