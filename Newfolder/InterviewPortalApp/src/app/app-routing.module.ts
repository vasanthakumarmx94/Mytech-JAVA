import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {LogoutComponent} from './logout/logout.component';
import {AdminHomeComponent} from './admin-home/admin-home.component';
import {UserHomeComponent} from './user-home/user-home.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { AddcompanyComponent } from './addcompany/addcompany.component';
import { ViewcompanyComponent } from './viewcompany/viewcompany.component';
import { AddExperienceComponent } from './add-experience/add-experience.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';
import { ProfileComponent } from './profile/profile.component';
import { UserViewquestionComponent } from './user-viewquestion/user-viewquestion.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'admin/home', component: AdminHomeComponent},
  {path: 'user/home', component: UserHomeComponent},
  {path: 'user/register', component: RegisterUserComponent},

  {path: 'admin/addcompany', component: AddcompanyComponent},
  {path: 'admin/viewcompany', component: ViewcompanyComponent},
  {path: 'admin/updateCompany/:id', component: AddcompanyComponent},
  {path: 'admin/addexperience', component: AddExperienceComponent},
  {path: 'admin/createquestion', component: CreateQuestionComponent},
  {path: 'admin/viewquestions/:id', component: ViewQuestionsComponent},
  {path: 'admin/viewquestions', component: ViewQuestionsComponent},

  {path: 'user/profile', component: ProfileComponent},
  {path: 'user/viewquestions', component: UserViewquestionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


