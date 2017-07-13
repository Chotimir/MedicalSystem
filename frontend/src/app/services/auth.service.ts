import {Injectable} from '@angular/core';
import {Http, Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {JwtHelper} from "angular2-jwt";

@Injectable()
export class AuthService {

  private authUrl = 'api/auth/';
  private headers = new Headers({'Content-Type': 'application/json'});

  static getToken(): string {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    const token = currentUser && currentUser.token;
    return token ? token : "";
  }

  static isLoggedIn(): boolean {
    const token: String = AuthService.getToken();
    return token && token.length > 0;
  }

  static isAdmin(): boolean {
    const token: String = AuthService.getToken();
    if (token && token.length > 0) {
      const jwtHelper: JwtHelper = new JwtHelper();
      const decoded = jwtHelper.decodeToken(token.toString());
      console.log(decoded);
      return false;
    }

    return false;
  }

  static logout(): void {
    localStorage.removeItem('currentUser');
  }

  constructor(private http: Http) {
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl + "login", JSON.stringify({username: username, password: password}), {headers: this.headers})
      .map((response: Response) => {
        const token = response.headers.get('Authorization');
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
          return true;
        } else {
          return false;
        }
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  register(fullName: string, email: string, username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl + "register",
      JSON.stringify({fullName: fullName, email: email, username: username, password: password}), {headers: this.headers})
      .map((response: Response) => {
        return response.ok;
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
