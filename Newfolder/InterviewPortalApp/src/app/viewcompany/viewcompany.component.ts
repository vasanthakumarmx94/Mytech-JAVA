import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Company } from '../model/Company';
import { CompanyService } from '../services/company.service';


@Component({
  selector: 'app-viewcompany',
  templateUrl: './viewcompany.component.html',
  styleUrls: ['./viewcompany.component.css']
})
export class ViewcompanyComponent implements OnInit {
  companies: Company[] = [];

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit(): void {
    this.getCompanies();
  }
  private getCompanies() {
    this.companyService.getCompanyList().subscribe(data => {
      console.log(data);
      this.companies = data;
      //this.dataSource.data=data as Company[];
    })
  }
  updateCompany(id: number) {
    this.router.navigate(['/admin/updateCompany', id])

  }
  deleteCompany(id: number) {
    this.companyService.deleteCompany(id).subscribe(data => {
      console.log(data);
      this.getCompanies();
    })
  }

  viewQuestions(id:number){
    this.router.navigate(['/admin/viewquestions', id])
  }



}
