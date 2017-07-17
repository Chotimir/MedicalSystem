import { Component, OnInit } from '@angular/core';
import {UsersService} from "../../services/users.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  providers: [UsersService]
})
export class AdminComponent implements OnInit {

  protected users: User[];

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.usersService.getUsers().then(users => this.users = users);
  }

  deactivate(user: User) {

  }

}
