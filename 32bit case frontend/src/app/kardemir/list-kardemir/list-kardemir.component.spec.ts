import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListKardemirComponent } from './list-kardemir.component';

describe('ListKardemirComponent', () => {
  let component: ListKardemirComponent;
  let fixture: ComponentFixture<ListKardemirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListKardemirComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListKardemirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
