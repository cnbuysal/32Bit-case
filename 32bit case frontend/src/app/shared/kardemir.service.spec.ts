import { TestBed } from '@angular/core/testing';

import { KardemirService } from './kardemir.service';

describe('KardemirService', () => {
  let service: KardemirService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KardemirService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
