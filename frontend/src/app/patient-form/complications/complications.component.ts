import {Component, OnDestroy, OnInit} from '@angular/core';
import {SelectField} from "../../model/select-field";
import {ActivatedRoute} from "@angular/router";
import {ComplicationsService} from "../../services/complications.service";

@Component({
  selector: 'app-complications',
  templateUrl: './complications.component.html',
  styleUrls: ['./complications.component.css'],
  providers: [ComplicationsService]
})
export class ComplicationsComponent implements OnInit, OnDestroy {

  patientId: string;
  complications: SelectField[];

  constructor(private complicationsService: ComplicationsService, private route: ActivatedRoute) { }

  getComplications(): void {
    this.complicationsService.getComplications(this.patientId).then(complications => this.complications = complications);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getComplications();
  }

  ngOnDestroy() {
    console.log(this.complications);
    this.complicationsService.updateComplications(this.complications, this.patientId);
  }

}
