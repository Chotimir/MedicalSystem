import { TestBed, inject } from '@angular/core/testing';

import { FollowUpVisitService } from './follow-up-visit.service';

describe('FollowUpVisitService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FollowUpVisitService]
    });
  });

  it('should be created', inject([FollowUpVisitService], (service: FollowUpVisitService) => {
    expect(service).toBeTruthy();
  }));
});
