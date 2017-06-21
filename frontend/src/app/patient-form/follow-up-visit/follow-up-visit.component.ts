import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

import {FollowUpVisit} from "../../model/follow-up-visit";
import {FollowUpVisitService} from "../../services/form/follow-up-visit.service";

@Component({
  selector: 'app-follow-up-visit',
  templateUrl: './follow-up-visit.component.html',
  styleUrls: ['./follow-up-visit.component.css']
})
export class FollowUpVisitComponent implements OnInit, OnDestroy {

  patientId: string;
  followUpVisit: FollowUpVisit;

  constructor(private followUpVisitService: FollowUpVisitService, private route: ActivatedRoute) { }

  getFollowUpVisit() {
    this.followUpVisitService.getFollowUpVisit(this.patientId).then(followUpVisit => this.followUpVisit = followUpVisit);
  }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.getFollowUpVisit();
  }

  ngOnDestroy() {
    console.log(this.followUpVisit);
    this.followUpVisitService.updateFollowUpVisit(this.followUpVisit, this.patientId);
  }

}
