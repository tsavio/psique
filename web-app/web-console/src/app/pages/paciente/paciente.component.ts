import { PacienteNameComponent } from './paciente-name/paciente-name.component';
import { ModalPatientComponent } from './modal-patient/modal-patient.component';
import { PacientService } from './../../services/pacient.service';
import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';

@Component({
  selector: 'ngx-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss'],
  providers:[PacientService]
})
export class PacienteComponent implements OnInit {
  
  constructor(private pacientService: PacientService, private dialogService: NbDialogService) {
  }

  pacientes : any = null;

  settings = {
    columns: {
      nome: {
        title: 'Nome',
        type: 'custom',
        renderComponent: PacienteNameComponent,                
      },
      telefone: {
        title: 'Telefone',
      },
      email: {
        title: 'E-mail',
      }
    }, 
    actions: false
  };
/*
  [{
asdd:dasd
  },
  [{

  },
  [{

  }];
  */
  getAllPacients(){
    this.pacientService.getAll().subscribe((response:any) => this.pacientes = response.data);
  }


  ngOnInit(){
    this.getAllPacients();
  }

 
  

}