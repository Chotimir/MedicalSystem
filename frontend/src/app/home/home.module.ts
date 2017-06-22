import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { PatientsComponent } from './patients/patients.component';
import { ImportComponent } from './import/import.component';
import { AdminComponent } from './admin/admin.component';
import {HomeRoutingModule} from "./home-routing.module";
import {TranslateModule} from "@ngx-translate/core";
import {FormsModule} from "@angular/forms";
import { ExportComponent } from './export/export.component';
import { FileUploadModule } from "ng2-file-upload";

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    TranslateModule,
    FormsModule,
    FileUploadModule
  ],
  declarations: [HomeComponent, PatientsComponent, ImportComponent, AdminComponent, ExportComponent]
})
export class HomeModule { }
