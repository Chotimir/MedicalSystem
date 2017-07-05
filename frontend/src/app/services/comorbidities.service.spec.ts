import { TestBed, inject } from '@angular/core/testing';

import { ComorbiditiesService } from './comorbidities.service';

describe('ComorbiditiesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComorbiditiesService]
    });
  });

  it('should be created', inject([ComorbiditiesService], (service: ComorbiditiesService) => {
    expect(service).toBeTruthy();
  }));
});
