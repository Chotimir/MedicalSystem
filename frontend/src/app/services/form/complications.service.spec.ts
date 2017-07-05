import { TestBed, inject } from '@angular/core/testing';

import { ComplicationsService } from './complications.service';

describe('ComplicationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComplicationsService]
    });
  });

  it('should be created', inject([ComplicationsService], (service: ComplicationsService) => {
    expect(service).toBeTruthy();
  }));
});
