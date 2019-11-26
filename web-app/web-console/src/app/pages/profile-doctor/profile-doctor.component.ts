import { Component, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';
import { DoctorService } from '../../services/doctor.service';


@Component({
  selector: 'ngx-profile-doctor',
  templateUrl: './profile-doctor.component.html',
  styleUrls: ['./profile-doctor.component.scss'],
  providers:[DoctorService]
})
export class ProfileDoctorComponent implements OnInit {

  constructor(private dialogService: NbDialogService, private doctorService:DoctorService) { }

  ngOnInit() {
  }

  doctor: any = null;
  
  settings = {
    columns: {
      name: {
        title: 'Nome',
        type: 'custom',
                    
      },
      phone: {
        title: 'Telefone',
      },
      email: {
        title: 'E-mail',
      },
      crp: {
        title: 'CRP',
      },

      cpf: {
        title: 'CPF',
      },

      login: {
        title: 'Login'
      }
    }, 
    actions: false
  };

  getDoctor(id){
    this.doctorService.getById(id).subscribe((response:any) => this.doctor = response.object);
  }

}
