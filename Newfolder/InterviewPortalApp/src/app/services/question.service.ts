import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Question } from '../model/Question';


@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private httpClient: HttpClient) { }

  createQuestion(question:Question):Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8080/admin/save_Questions"}`,question);
  }
  getAllQuestionsList():Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${"http://localhost:8080/getAllQuestions"}`)
  }

  getQuestionById(id:number):Observable<Question>{
    return this.httpClient.get<Question>(`${"http://localhost:8080/questions"}/${id}`);
  }

  getQuestionsByCompanyId(id:number):Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${"http://localhost:8080/questions/company"}/${id}`);
  }

  getQuestionsByExperience(id:number):Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${"http://localhost:8080/questions/experience"}/${id}`);
  }

  getQuestionsByCompanyExperience(cid:number,Eid:number):Observable<Question[]>{
    return this.httpClient.get<Question[]>(`${"http://localhost:8080/questions/company/experience"}/${cid}/${Eid}`);
  }

}
