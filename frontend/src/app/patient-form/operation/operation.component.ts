import {Component, OnDestroy, OnInit} from '@angular/core';
import {Operation} from "../../model/operation";
import {ActivatedRoute} from "@angular/router";
import {OperationService} from "../../services/form/operation.service";

@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css']
})
export class OperationComponent implements OnInit, OnDestroy {

  patientId: string;
  operation: Operation;

  constructor(private operationService: OperationService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.operation = this.route.snapshot.data['operation'];
  }

  ngOnDestroy() {
    console.log(this.operation);
    this.operationService.updateOperation(this.operation, this.patientId);
  }

}
