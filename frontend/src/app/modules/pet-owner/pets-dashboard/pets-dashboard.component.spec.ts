import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetsDashboardComponent } from './pets-dashboard.component';

describe('PetsDashboardComponent', () => {
  let component: PetsDashboardComponent;
  let fixture: ComponentFixture<PetsDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetsDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetsDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
