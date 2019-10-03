import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacienteNameComponent } from './paciente-name.component';

describe('PacienteNameComponent', () => {
  let component: PacienteNameComponent;
  let fixture: ComponentFixture<PacienteNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacienteNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacienteNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
