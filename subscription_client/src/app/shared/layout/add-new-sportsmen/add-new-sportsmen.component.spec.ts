import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewSportsmenComponent } from './add-new-sportsmen.component';

describe('AddNewSportsmenComponent', () => {
  let component: AddNewSportsmenComponent;
  let fixture: ComponentFixture<AddNewSportsmenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewSportsmenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddNewSportsmenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
