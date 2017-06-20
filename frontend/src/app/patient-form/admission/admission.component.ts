import {Component, OnDestroy, OnInit} from '@angular/core';
import {Admission} from "../../model/admission";
import {AdmissionService} from "../../services/form/admission.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css'],
  providers: [AdmissionService]
})
export class AdmissionComponent implements OnInit, OnDestroy {

  patientId: string;
  admission: Admission;

  constructor(private admissionService: AdmissionService, private route: ActivatedRoute) { }

  getAdmission() {
    this.admissionService.getAdmission(this.patientId).then(admission => this.admission = admission);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getAdmission();
  }

  ngOnDestroy() {
    console.log(this.admission);
    this.admissionService.updateAdmission(this.admission, this.patientId);
  }

}
