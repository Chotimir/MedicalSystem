import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  private pending: boolean;
  private username: string;
  private password: string;
  private error: string;

  constructor(private router: Router, private authService: AuthService) { }

ngOnInit() {
  this.pending = false;
}

  login() {
    this.pending = true;
    this.authService.login(this.username, this.password)
      .subscribe(result => {
        if (result === true) {
          this.router.navigate(['home']);
        } else {
          this.error = 'Unknown error';
          this.pending = false;
        }
      }, error => {
        this.pending = false;
        this.error = error;
      });
  }
}
