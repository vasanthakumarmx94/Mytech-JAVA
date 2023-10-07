import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User;
  role: string;
  constructor(private httpClient: HttpClient) { }
  Authenticate(username: string, password: string) {
    this.getUserByEmailAndPassword(username, password).subscribe(data => {
      this.user = data;
      sessionStorage.setItem('username', this.user.email);
      sessionStorage.setItem('role', this.user.role);
    },
      error => console.log(error));
  }
  isUserLogedin() {
    let user = sessionStorage.getItem('username');
    //console.log(!(user === null))
    return (user != null)
  }

  getRole(): any {
    return sessionStorage.getItem('role');
  }
  getEmail(): any {
    return sessionStorage.getItem('username');
  }


  getUserByEmailAndPassword(username: String, password: String): Observable<User> {
    return this.httpClient.get<User>(`${"http://localhost:8080/signin"}/${username}/${password}`);
  }

  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('role');
      
  }


}
