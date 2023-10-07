import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { UserService } from '../services/user.service';
import {AuthService} from '../services/auth.service';




@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService, private router: Router,private authService:AuthService) { }
  email:string

  user:User;
  ngOnInit(): void {
    this.email= this.authService.getEmail();
    this.userService.getUserbyEmail(this.email).subscribe(data=>{
      this.user=data;
      console.log(this.user);
    }, error => console.log(error));
  }




}
