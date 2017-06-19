import {Component, OnDestroy, OnInit} from '@angular/core';
import {Examination} from "../../model/examination";
import {ExaminationsService} from "../../services/form/examinations.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-examinations',
  templateUrl: './examinations.component.html',
  styleUrls: ['./examinations.component.css'],
  providers: [ExaminationsService]
})
export class ExaminationsComponent implements OnInit, OnDestroy {

  patientId: string;
  examinations: Examination[];

  constructor(private examinationsService: ExaminationsService, private route: ActivatedRoute) { }

  getExaminations(): void {
    this.examinationsService.getExaminations(this.patientId).then(examinations => this.examinations = examinations);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getExaminations();
  }

  ngOnDestroy() {
    console.log(this.examinations);
    this.examinationsService.updateExaminations(this.examinations, this.patientId);
  }

}
