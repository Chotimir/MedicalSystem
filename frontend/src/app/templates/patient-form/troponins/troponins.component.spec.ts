import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TroponinsComponent } from './troponins.component';

describe('TroponinsComponent', () => {
  let component: TroponinsComponent;
  let fixture: ComponentFixture<TroponinsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TroponinsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TroponinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
