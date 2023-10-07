import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Question } from '../model/Question';
import { QuestionService } from '../services/question.service';
import { ExperienceService } from '../services/experience.service';
import { Experience } from '../model/Experience';
import { CompanyService } from '../services/company.service';
import { Company } from '../model/Company';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {

  constructor(private questionService: QuestionService, private experienceService: ExperienceService, private route: ActivatedRoute,
    private router: Router, private companyService: CompanyService,) { }
  experiences: Experience[] = [];
  companies: Company[] = [];
  questions: Question[] = [];
  cid: number;
  Eid:number;

  experience:Experience;

  question: Question = new Question();

  ngOnInit(): void {
    this.getAllExperience();
    this.getAllcompany();
    this.cid = this.route.snapshot.params['id'];
    console.log(this.cid);
    this.getQuestionsCompany();
  }

  getAllExperience() {
    this.experienceService.getExperienceList().subscribe(data => {
      console.log(data);
      this.experiences = data;
    }, error => console.log(error))
  }

  getAllcompany() {
    this.companyService.getCompanyList().subscribe(data => {
      console.log(data);
      this.companies = data;
    }, error => console.log(error))
  }

  setActive = function (buttonName){
    this.activeButton = buttonName;
  }
  isActive = function (buttonName){
    return this.activeButton === buttonName;
  }

  getAllQuestionsByCompany(id: number) {
    this.cid = id;
    this.getQuestionsCompany();
    // this.questionService.getQuestionsByCompanyId(id).subscribe(data=>{
    //   console.log(data);
    //  this.questions=data;
    //   console.log(this.questions);
    //}, error => console.log(error))
  }
  getAllQuestionsByExperience(id: number) {
      this.Eid=id;
      this.getQuestionsCompanyExperience();
  }

  private getQuestionsCompany() {
    if (this.cid > 0) {
      this.questionService.getQuestionsByCompanyId(this.cid).subscribe(data => {
        console.log(data);
        this.questions = data;
        //console.log(this.questions);
      }, error => console.log(error))
    } else {
      this.getAllQuestions();
    }
  }

  private getQuestionsExperience() {
    
      this.questionService.getQuestionsByExperience(this.Eid).subscribe(data => {
        console.log(data);
        this.questions = data;
        //console.log(this.questions);
      }, error => console.log(error))
    
  }

  private getQuestionsCompanyExperience() {
    
    this.questionService.getQuestionsByCompanyExperience(this.cid,this.Eid).subscribe(data => {
      console.log(data);
      this.questions = data;
      //console.log(this.questions);
    }, error => console.log(error))
  
}

viewAllQuestions(){
  this.getAllQuestions();
}

  private getAllQuestions() {
    this.questionService.getAllQuestionsList().subscribe(data => {
      console.log(data);
      this.questions = data;
      console.log(this.questions);
    }, error => console.log(error))
  }



  updateQuestion(id: number) {

  }
  deleteQuestion(id: number) {

  }

}
