import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {Experience} from '../model/Experience';
import {ExperienceService} from '../services/experience.service';

@Component({
  selector: 'app-add-experience',
  templateUrl: './add-experience.component.html',
  styleUrls: ['./add-experience.component.css']
})
export class AddExperienceComponent implements OnInit {

  id:number
  experience:Experience=new Experience();

  constructor(private experienceService: ExperienceService,private route:ActivatedRoute,
     private router: Router) { }

  ngOnInit(): void {
  }

  saveCompany() {
    this.experienceService.SaveExperience(this.experience).subscribe(data => {
      console.log(data);
      this.goToCompanyList();
    },error => console.log(error));
  }

  goToCompanyList() {
    alert("Experience Added successfully");
    this.router.navigate(['/admin/viewcompany']);
  }


  onSubmit() {
    console.log(this.experience);
    this.saveCompany();
  }

}
