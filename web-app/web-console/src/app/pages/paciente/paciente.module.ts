import { ThemeModule } from './../../@theme/theme.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PacienteComponent } from './paciente.component';
import { ModalPatientComponent } from './modal-patient/modal-patient.component';
import { ShowcaseDialogComponent } from '../modal-overlays/dialog/showcase-dialog/showcase-dialog.component'

/* MODULES IMPORT */
import { NbCardModule, NbDialogModule, NbAlertModule, NbButtonModule, NbIconModule } from '@nebular/theme';
import { PacienteNameComponent } from './paciente-name/paciente-name.component';


const MODULES = [
  NbCardModule,
  CommonModule,
  Ng2SmartTableModule,
  ThemeModule,
  NbDialogModule.forRoot(),
  NbAlertModule,
  NbButtonModule,
  NbIconModule
]

const COMPONENTS = [ 
  PacienteComponent,
]

@NgModule({
  declarations: [
    ...COMPONENTS,
    ModalPatientComponent,
    PacienteNameComponent
  ],
  imports: [
    ...MODULES
  ],
  entryComponents: [ModalPatientComponent, PacienteNameComponent]
})
export class PacienteModule { }
