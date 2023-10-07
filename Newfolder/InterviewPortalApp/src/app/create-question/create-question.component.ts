import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import {Question} from '../model/Question';
import {QuestionService} from '../services/question.service';
import {ExperienceService} from '../services/experience.service';
import { Experience } from '../model/Experience';
import {CompanyService} from '../services/company.service';
import { Company } from '../model/Company';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  experiences:Experience[]=[];
  companies:Company[]=[];


  question:Question=new Question();
  experience:Experience;
  company:Company;
  
  constructor(private questionService: QuestionService,private experienceService: ExperienceService,private route:ActivatedRoute,
  private router: Router,private companyService: CompanyService) { }

  ngOnInit(): void {
    this.experienceService.getExperienceList().subscribe(data => {
      //console.log(data);
      this.experiences=data;
    }, error => console.log(error));

    this.companyService.getCompanyList().subscribe(data => {
      //console.log(data);
      this.companies=data;
    }, error => console.log(error));

  }
 
  saveQuestion() {

    console.log(this.company.id);
    this.companyService.getCompanyById(this.company.id).subscribe(data => {
      //console.log(data);
      this.company=data;
    },error => console.log(error));

    console.log(this.experience);
    this.experienceService.getExperienceById(this.experience.id).subscribe(data => {
      //console.log(data);
      this.experience=data;
    },error => console.log(error));

    this.question.experience=this.experience;
    this.question.company=this.company;
    this.questionService.createQuestion(this.question).subscribe(data => {
      console.log(data);
      this.goToQuestionList();
    },
      error => console.log(error));
  }
  goToQuestionList() {
    alert("Question Added successfully");
    this.router.navigate(['/admin/viewcompany']);
  }



  onSubmit() {
    //console.log(this.company);
    this.saveQuestion();
  }


}
