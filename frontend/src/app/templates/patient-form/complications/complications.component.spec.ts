import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplicationsComponent } from './complications.component';

describe('ComplicationsComponent', () => {
  let component: ComplicationsComponent;
  let fixture: ComponentFixture<ComplicationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComplicationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
