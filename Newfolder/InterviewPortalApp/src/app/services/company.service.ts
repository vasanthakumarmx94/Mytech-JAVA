import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../model/Company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private httpClient:HttpClient) { }

  createCompany(company:Company):Observable<Object>{
    return this.httpClient.post(`${"http://localhost:8080/admin/save_company"}`,company);
  }
  getCompanyList():Observable<Company[]>{
    return this.httpClient.get<Company[]>(`${"http://localhost:8080/getAllcompanies"}`)
  }
  getCompanyById(id:number):Observable<Company>{
    return this.httpClient.get<Company>(`${"http://localhost:8080/company"}/${id}`);
  }
  
  updateCompany(id:number,company:Company):Observable<Object>{
  return this.httpClient.put(`${"http://localhost:8080/admin/company"}/${id}`,company);
  }
  
  deleteCompany(id:number):Observable<Object>{
    return this.httpClient.delete(`${"http://localhost:8080/admin/company"}/${id}`)
  }
}
