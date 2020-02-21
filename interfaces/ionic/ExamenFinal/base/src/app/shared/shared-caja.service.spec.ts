import { TestBed } from '@angular/core/testing';

import { SharedCajaService } from './shared-caja.service';

describe('SharedCajaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SharedCajaService = TestBed.get(SharedCajaService);
    expect(service).toBeTruthy();
  });
});
