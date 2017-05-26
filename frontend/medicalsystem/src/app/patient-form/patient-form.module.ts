import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { PatientFormRoutingModule } from "./patient-form-routing.module";
import { PatientFormComponent } from './patient-form.component';
import { PersonalDataComponent } from "./personal-data/personal-data.component";

@NgModule({
  imports: [
    CommonModule,
    TranslateModule,
    PatientFormRoutingModule,

  ],
  declarations: [
    PatientFormComponent,
    PersonalDataComponent
  ]
})
export class PatientFormModule { }
