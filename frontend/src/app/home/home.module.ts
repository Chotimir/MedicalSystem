import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { SearchComponent } from './search/search.component';
import { ImportComponent } from './import/import.component';
import { AdminComponent } from './admin/admin.component';
import {HomeRoutingModule} from "./home-routing.module";
import {TranslateModule} from "@ngx-translate/core";
import {FormsModule} from "@angular/forms";
import { ExportComponent } from './export/export.component';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    TranslateModule,
    FormsModule
  ],
  declarations: [HomeComponent, SearchComponent, ImportComponent, AdminComponent, ExportComponent]
})
export class HomeModule { }
