import {Component, OnDestroy, OnInit} from '@angular/core';
import {Operation} from "../../model/operation";
import {ActivatedRoute} from "@angular/router";
import {OperationService} from "../../services/operation.service";

@Component({
  selector: 'app-operation',
  templateUrl: './operation.component.html',
  styleUrls: ['./operation.component.css'],
  providers: [OperationService]
})
export class OperationComponent implements OnInit, OnDestroy {

  patientId: string;
  operation: Operation;

  constructor(private operationService: OperationService, private route: ActivatedRoute) { }

  getOperation(): void {
    this.operationService.getOperation(this.patientId).then(operation => this.operation = operation);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getOperation();
  }

  ngOnDestroy() {
    console.log(this.operation);
    this.operationService.updateOperation(this.operation, this.patientId);
  }

}
