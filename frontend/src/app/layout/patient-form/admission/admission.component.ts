import {Component, OnDestroy, OnInit} from '@angular/core';
import {Admission} from "../../../model/admission";
import {AdmissionService} from "../../../core/services/form/admission.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css']
})
export class AdmissionComponent implements OnInit, OnDestroy {

  patientId: string;
  admission: Admission;

  constructor(private admissionService: AdmissionService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.admission = this.route.snapshot.data['admission'];
  }

  ngOnDestroy() {
    console.log(this.admission);
    this.admissionService.updateAdmission(this.admission, this.patientId);
  }

}
