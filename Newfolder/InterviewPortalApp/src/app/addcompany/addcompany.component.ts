import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {Company} from '../model/Company';
import {CompanyService} from '../services/company.service';

@Component({
  selector: 'app-addcompany',
  templateUrl: './addcompany.component.html',
  styleUrls: ['./addcompany.component.css']
})
export class AddcompanyComponent implements OnInit {

  company: Company = new Company();
  constructor(private companyService: CompanyService,private route:ActivatedRoute,
     private router: Router) { }
  id:number=null;
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.companyService.getCompanyById(this.id).subscribe(data=>{
      this.company=data;
      //console.log(data);
    },error=>console.log(error));
  }
  saveCompany() {
    this.companyService.createCompany(this.company).subscribe(data => {
      //console.log(data);
      this.goToCompanyList();
    },
      error => console.log(error));
  }
  goToCompanyList() {
    alert("Company Added successfully");
    this.router.navigate(['/admin/viewcompany']);
  }


  onSubmit() {
    //console.log(this.company);
    this.saveCompany();
  }

}
