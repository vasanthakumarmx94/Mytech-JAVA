import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Question } from '../model/Question';
import { QuestionService } from '../services/question.service';
import { ExperienceService } from '../services/experience.service';
import { Experience } from '../model/Experience';
import { CompanyService } from '../services/company.service';
import { Company } from '../model/Company';
import { User } from '../model/User';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-user-viewquestion',
  templateUrl: './user-viewquestion.component.html',
  styleUrls: ['./user-viewquestion.component.css']
})
export class UserViewquestionComponent implements OnInit {

  constructor(private questionService: QuestionService, private authService: AuthService, private userService: UserService,
    private router: Router, private companyService: CompanyService) { }
  experiences: Experience[] = [];
  companies: Company[] = [];
  questions: Question[] = [];
  cid: number;
  Eid: number;
  email: string;
  companyName:string;
  i:number;

  experience: Experience;
  company:Company;
  question: Question = new Question();
  user: User = new User();

  ngOnInit(): void {
    this.getUserDetails();
    this.getAllcompany();
    this.getAllQuestions();
  }
  getUserDetails() {
    this.email = this.authService.getEmail();
    this.userService.getUserbyEmail(this.email).subscribe(data => {
      this.user = data;
      this.Eid=this.user.experience.id;
      console.log(this.user);
    }, error => console.log(error));
  }

  getAllcompany() {
    this.companyService.getCompanyList().subscribe(data => {
      console.log(data);
      this.companies = data;
    }, error => console.log(error))
  }


  getAllQuestionsByCompany(id: number) {
    this.cid = id;
    this.getCompanyById(this.cid);
    this.getQuestionsByCompanyAndExperience();
  }
  getCompanyById(cid:number){
    this.companyService.getCompanyById(cid).subscribe(data => {
      console.log(data);
      this.company= data;
    }, error => console.log(error))
  }

  getQuestionsByCompanyAndExperience() {
    this.questionService.getQuestionsByCompanyExperience(this.cid,this.Eid).subscribe(data => {
      console.log(data);
      this.questions = data;
      this.companyName=this.company.companyName;
      //console.log(this.questions);
    }, error => console.log(error))
  }

  viewAllQuestions() {
    this.companyName="All";
    this.getAllQuestions();
    
  }
  getAllQuestions(){
    this.questionService.getAllQuestionsList().subscribe(data => {
      console.log(data);
      this.questions = data;
      this.i=0;
      console.log(this.questions);
    }, error => console.log(error))
  }



}
