import { PacientService } from './../../services/pacient.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss'],
  providers:[PacientService]
})
export class PacienteComponent implements OnInit {
  
  constructor(private pacientService: PacientService) {
  }

  pacientes : any = null;

  settings = {
    columns: {
      nome: {
        title: 'Nome',     
      },
      telefone: {
        title: 'Telefone',
      },
      email: {
        title: 'E-mail',
      }
    }, 
    actions: false,
  }

  getAllPacients(){
    this.pacientService.getAll().subscribe((response:any) => this.pacientes = response.data);
  }

  ngOnInit(){
    this.getAllPacients();
  }

  

}