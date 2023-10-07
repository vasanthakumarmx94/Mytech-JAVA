import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  registerUser(user:User):Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8080/user/register"}`,user);
  }
  getUserbyEmail(email:string):Observable<User>{
    return this.httpClient.get<User>(`${"http://localhost:8080/getuserbyMail"}/${email}`);
  }

}
