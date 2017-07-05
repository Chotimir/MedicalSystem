import { TestBed, inject } from '@angular/core/testing';

import { TroponinsService } from './troponins.service';

describe('TroponinsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TroponinsService]
    });
  });

  it('should be created', inject([TroponinsService], (service: TroponinsService) => {
    expect(service).toBeTruthy();
  }));
});
