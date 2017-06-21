import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowUpVisitComponent } from './follow-up-visit.component';

describe('FollowUpVisitComponent', () => {
  let component: FollowUpVisitComponent;
  let fixture: ComponentFixture<FollowUpVisitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FollowUpVisitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FollowUpVisitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
