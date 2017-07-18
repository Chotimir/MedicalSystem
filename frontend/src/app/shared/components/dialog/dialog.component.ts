import {Component, Input, OnInit} from "@angular/core";

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  @Input() type: string;
  @Input() message: string;

  constructor() {}

  ngOnInit() {}

}
