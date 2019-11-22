import { PacienteNameComponent } from './paciente-name/paciente-name.component';
import { ModalPatientComponent } from './modal-patient/modal-patient.component';
import { PatientService } from '../../services/patient.service';
import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';

@Component({
  selector: 'ngx-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss'],
  providers:[PatientService]
})
export class PacienteComponent implements OnInit {
  
  constructor(private pacientService: PatientService, private dialogService: NbDialogService) {
  }

  pacientes : any = null;

  settings = {
    columns: {
      name: {
        title: 'Nome',
        type: 'custom',
        renderComponent: PacienteNameComponent,                
      },
      phone: {
        title: 'Telefone',
      },
      email: {
        title: 'E-mail',
      }
    }, 
    actions: false
  };

  getAllPacients(){
    this.pacientService.getAll().subscribe((response:any) => this.pacientes = response.data);
  }

  ngOnInit(){
    this.getAllPacients();
  }
}