import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewquestionComponent } from './user-viewquestion.component';

describe('UserViewquestionComponent', () => {
  let component: UserViewquestionComponent;
  let fixture: ComponentFixture<UserViewquestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewquestionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewquestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
