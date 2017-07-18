import {Component, OnInit} from "@angular/core";
import {AuthService} from "../../../core/services/auth.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [AuthService]
})
export class RegistrationComponent implements OnInit {

  private fullName: string;
  private email: string;
  private username: string;
  private password: string;
  private repeated: string;

  private error: string;
  private info: string;
  private pending: boolean;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.pending = false;
  }

  register() {
    if (this.password !== this.repeated) {
      this.error = 'Podane hasła nie są zgodne';
      return;
    }
    this.pending = true;
    this.authService.register(this.fullName, this.email, this.username, this.password)
      .subscribe(
        result => {
          if (result === true) {
            this.pending = false;
            this.info = 'Przyjęliśmy prośbę o utworzenie konta.\n' +
              'Poczekaj na wiadomość email weryfikującą podany adres i akceptację konta.';
          }
        },
        error => {
          this.pending = false;
          this.error = error;
        });
  }

}
