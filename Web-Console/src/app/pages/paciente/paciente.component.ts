import { Component, Input } from '@angular/core';

@Component({
  selector: 'ngx-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent {

  pacientes = [ 
    {
    id: 1,
    name: 'Arthur',
    localidade: 'Janga',
    idade: '22',
  }
  ,
  {
    id: 2,
    name: 'Thyago',
    localidade: 'Olinda',
    idade: '22',
  },
  {
    id: 3,
    name: 'Pedro',
    localidade: 'Rio Doce',
    idade: '25',
  },
  {
    id: 4,
    name: 'Clayton',
    localidade: 'Aguas Compridas',
    idade: '50',
  }
  ,
  {
    id: 5,
    name: 'Neguinho',
    localidade: 'Peixinho',
    idade: '26',
  },
  {
    id: 6,
    name: 'Farias',
    localidade: 'Abreu',
    idade: '60',
  },
];

  settings = {
    columns: {
      name: {
        title: 'Nome',     
      },
      localidade: {
        title: 'Localidade',
      },
      idade: {
        title: 'Idade',
      }
    }, 
    actions: false,
  } 

  
  constructor() {
  }

}