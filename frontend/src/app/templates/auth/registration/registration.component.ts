import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [AuthService]
})
export class RegistrationComponent implements OnInit {

  private pending: boolean;
  private fullName: string;
  private email: string;
  private username: string;
  private password: string;
  private repeated: string;
  private error: string;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit() {
    this.pending = false;
  }

  register() {
    if (this.password !== this.repeated) {
      this.error = 'Passwords not matching';
      return;
    }
    this.pending = true;
    this.authService.register(this.fullName, this.email, this.username, this.password)
      .subscribe(result => {
        if (result === true) {
          alert("Registration successful. You can now log in");
          this.router.navigate(['login']);
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
