import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { AddcompanyComponent } from './addcompany/addcompany.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { ViewcompanyComponent } from './viewcompany/viewcompany.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { AddExperienceComponent } from './add-experience/add-experience.component';
import { ViewQuestionsComponent } from './view-questions/view-questions.component';
import { ProfileComponent } from './profile/profile.component';
import { UserViewquestionComponent } from './user-viewquestion/user-viewquestion.component';
import { AddRequestComponent } from './add-request/add-request.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    HomeComponent,
    AdminHomeComponent,
    UserHomeComponent,
    AddcompanyComponent,
    RegisterUserComponent,
    ViewcompanyComponent,
    CreateQuestionComponent,
    AddExperienceComponent,
    ViewQuestionsComponent,
    ProfileComponent,
    UserViewquestionComponent,
    AddRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
