import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapResult2Component } from './map-result2.component';

describe('MapResult2Component', () => {
  let component: MapResult2Component;
  let fixture: ComponentFixture<MapResult2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MapResult2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MapResult2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
