import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {User} from "../model/user";

@Injectable()
export class UsersService {

  private usersUrl = 'api/users/';

  constructor(private http: Http) { }

  getUsers(): Promise<User[]> {
    return this.http.get(this.usersUrl).toPromise()
      .then(response => response.json() as User[])
      .catch(this.handleError);
  }

  getStatusList(): Promise<string[]> {
    return this.http.get(this.usersUrl + 'statusList').toPromise()
      .then(response => response.json() as string[])
      .catch(this.handleError);
  }

  setStatus(userId: string, status: string): Promise<boolean> {
    return this.http.post(this.usersUrl + userId + '/status', JSON.stringify(status)).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  setAdminRights(userId: string, admin: boolean): Promise<boolean> {
    return this.http.post(this.usersUrl + userId + '/admin', JSON.stringify(admin)).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  deleteUser(userId: string): Promise<boolean> {
    return this.http.delete(this.usersUrl + userId).toPromise()
      .then(response => response.json() as boolean)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
