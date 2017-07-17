import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {

  patientId: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.patientId = this.route.snapshot.params['id'];
  }

}
