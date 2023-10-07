import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { ExperienceService } from '../services/experience.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {

  user: User = new User();

  constructor(private userService: UserService, private experienceService: ExperienceService, private router: Router) { }

  ngOnInit(): void {
  }
  experienceLevel: number;
  saveUser() {
    this.user.status = 1;
    this.user.role = "user";
    this.experienceService.getExperienceById(this.experienceLevel).subscribe(data => {
      console.log(data);
      this.user.experience = data;
      this.registerUser()
    }, error => console.log(error));
  }
  registerUser() {
    this.userService.registerUser(this.user).subscribe(data => {
      console.log(data);
      this.goToCompanyList();
    },
      error => console.log(error));
  }
  goToCompanyList() {
    alert("Register Successfully");
    this.router.navigate(['/login']);
  }



  onSubmit() {
    console.log(this.user);
    this.saveUser();
  }
}
