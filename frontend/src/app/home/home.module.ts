import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { PatientSearchComponent } from './patient-navigation/patient-search/patient-search.component';
import { ImportComponent } from './import/import.component';
import { AdminComponent } from './admin/admin.component';
import {HomeRoutingModule} from "./home-routing.module";
import {TranslateModule} from "@ngx-translate/core";
import {FormsModule} from "@angular/forms";
import { ExportComponent } from './export/export.component';
import { FileUploadModule } from "ng2-file-upload";
import { CreatePatientComponent } from './patient-navigation/create-patient/create-patient.component';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    TranslateModule,
    FormsModule,
    FileUploadModule
  ],
  declarations: [HomeComponent, PatientSearchComponent, ImportComponent, AdminComponent, ExportComponent, CreatePatientComponent]
})
export class HomeModule { }
