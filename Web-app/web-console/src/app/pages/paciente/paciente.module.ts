import { ThemeModule } from './../../@theme/theme.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PacienteComponent } from './paciente.component';

/* MODULES IMPORT */
import {
  NbCardModule
} from '@nebular/theme';

const MODULES = [
  NbCardModule,
  CommonModule,
  Ng2SmartTableModule,
  ThemeModule
]

const COMPONENTS = [ 
  PacienteComponent
]

@NgModule({
  declarations: [
    ...COMPONENTS
  ],
  imports: [
    ...MODULES
  ]
})
export class PacienteModule { }
