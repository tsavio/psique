import { PacienteNameComponent } from './paciente-name/paciente-name.component';
import { ModalPatientComponent } from './modal-patient/modal-patient.component';
import { PatientService } from '../../services/patient.service';
import { DoctorService } from '../../services/doctor.service';
import { Component, Input, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';

@Component({
  selector: 'ngx-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss'],
  providers:[PatientService]
})
export class PacienteComponent implements OnInit {
  
  constructor(private pacientService: PatientService, private doctorService:DoctorService,private dialogService: NbDialogService) {
  }

  doctor = {};
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
    this.pacientService.getAll().subscribe((response:any) => this.pacientes = response.object);
  }

  addDoctor(){
    this.doctorService.store(this.doctor).subscribe((response:any) => this.getAllPacients());
  }

  ngOnInit(){
    this.getAllPacients();
  }
}