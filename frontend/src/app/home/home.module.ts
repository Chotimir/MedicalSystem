import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { SearchComponent } from './search/search.component';
import { ImportComponent } from './import/import.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [HomeComponent, SearchComponent, ImportComponent, AdminComponent]
})
export class HomeModule { }
