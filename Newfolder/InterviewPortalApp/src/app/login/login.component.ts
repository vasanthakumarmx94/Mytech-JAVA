import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { User } from '../model/User';
import {AuthService} from '../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  username: string;
  password : string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin =false;
  loginSuccess = false;


  user:User=new User();
  role:string;
  constructor(private authService:AuthService,private router: Router) {
    
   }

  ngOnInit(): void {
    

  }

  checkLogin(){
    this.authService.Authenticate(this.username,this.password);
    
    if (this.authService.isUserLogedin()) {
      this.loginSuccess = true;
      this.successMessage="login successfully"
      this.role=this.authService.getRole();
      if(this.role === "admin"){
        this.router.navigate(['admin/home']).then(() => {
          window.location.reload();
        });
      }else{
        this.router.navigate(['user/home']).then(() => {
          window.location.reload();
        });
      }
      
      
    } else {
      this.invalidLogin = true;
      this.router.navigate(['/login'])  
    }
    
  }
 
  onSubmit() {
    this.checkLogin();
  }



}
