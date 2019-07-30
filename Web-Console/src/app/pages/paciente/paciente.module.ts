import { ThemeModule } from './../../@theme/theme.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PacienteComponent } from './paciente.component';
@NgModule({
  declarations: [
    PacienteComponent
  ],
  imports: [
    CommonModule,
    Ng2SmartTableModule,
    ThemeModule
  ]
})
export class PacienteModule { }
