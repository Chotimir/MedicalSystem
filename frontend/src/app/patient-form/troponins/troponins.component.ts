import {Component, OnDestroy, OnInit} from '@angular/core';
import {TroponinsService} from "../../services/form/troponins.service";
import {Troponins} from "../../model/troponins";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-troponins',
  templateUrl: './troponins.component.html',
  styleUrls: ['./troponins.component.css']
})
export class TroponinsComponent implements OnInit, OnDestroy {

  patientId: string;
  troponins: Troponins;

  constructor(private troponinsService: TroponinsService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.patientId = this.route.parent.snapshot.params['id'];
    this.troponins = this.route.snapshot.data['troponins'];
  }

  ngOnDestroy() {
    console.log(this.troponins);
    this.troponinsService.updateTroponins(this.troponins, this.patientId);
  }

}
