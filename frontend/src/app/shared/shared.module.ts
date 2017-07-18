import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {DialogComponent} from "./components/dialog/dialog.component";
import {FormsModule} from "@angular/forms";
import {TranslateModule} from "@ngx-translate/core";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    DialogComponent
  ],
  exports: [
    CommonModule,
    FormsModule,
    TranslateModule,
    DialogComponent
  ]
})
export class SharedModule { }
