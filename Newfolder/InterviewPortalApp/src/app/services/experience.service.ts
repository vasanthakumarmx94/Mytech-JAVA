import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Experience } from '../model/Experience';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  constructor(private httpClient: HttpClient) { }


  SaveExperience(experience:Experience):Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8080/admin/save_experience"}`,experience);
  }

  getExperienceById(id:number):Observable<Experience>{
    return this.httpClient.get<Experience>(`${"http://localhost:8080/experience"}/${id}`);
  }
  getExperienceList():Observable<Experience[]>{
    return this.httpClient.get<Experience[]>(`${"http://localhost:8080/getAllExperiences"}`)
  }

}
