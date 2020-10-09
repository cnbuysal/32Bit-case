import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateKardemirComponent } from './create-kardemir.component';

describe('CreateKardemirComponent', () => {
  let component: CreateKardemirComponent;
  let fixture: ComponentFixture<CreateKardemirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateKardemirComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateKardemirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
