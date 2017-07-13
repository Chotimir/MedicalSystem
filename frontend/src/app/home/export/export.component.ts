import {Component, OnInit} from '@angular/core';
import {ExportService} from "../../services/export.service";
import {saveAs} from "file-saver";

@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.css'],
  providers: [ExportService]
})
export class ExportComponent implements OnInit {

  private filename = "patientsData.xlsx";

  constructor(private exportService: ExportService) { }

  ngOnInit() {
  }

  download() {
    this.exportService.exportExcel().then(blob => {
      saveAs(blob, this.filename);
    });
  }

}
