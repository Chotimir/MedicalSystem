import {Component, OnInit} from "@angular/core";
import {FileUploader} from "ng2-file-upload";
import {AuthService} from "../../../communication/services/auth.service";

const URL = 'api/import/excel';

@Component({
  selector: 'app-import',
  templateUrl: './import.component.html',
  styleUrls: ['./import.component.css']
})
export class ImportComponent implements OnInit {

  public uploader: FileUploader;

  ngOnInit() {
    this.uploader = new FileUploader({url: URL});
    this.uploader.authToken = AuthService.getToken();
  }

}
