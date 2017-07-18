import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../../../core/services/auth.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private error: string;
  private pending: boolean;

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    this.pending = false;
  }

  login() {
    this.pending = true;
    this.authService.login(this.username, this.password)
      .subscribe(
        result => {
          if (result === true) {
            this.router.navigate(['home']);
          }
        },
        error => {
          this.pending = false;
          this.error = error;
        });
  }
}
