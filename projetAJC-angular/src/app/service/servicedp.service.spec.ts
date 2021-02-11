import { TestBed } from '@angular/core/testing';

import { ServicedpService } from './servicedp.service';

describe('ServicedpService', () => {
  let service: ServicedpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicedpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
