import { messages } from './../../pages/extra-components/chat/messages';
import { RequestResult } from './../../models/RequestResult';
import { DoctorService } from './../../services/doctor.service';
import { NbDialogService, NbDialogRef, NbThemeService, NbToastrService } from '@nebular/theme';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-create-user-modal',
  templateUrl: './create-user-modal.component.html',
  styleUrls: ['./create-user-modal.component.scss']
})
export class CreateUserModalComponent implements OnInit {

  constructor(dialogService: NbDialogService, 
            protected ref: NbDialogRef<CreateUserModalComponent>, 
            private doctorService: DoctorService,
            private theme: NbThemeService,
            private toastService: NbToastrService) { }

  user: object = {
        login: "",
        password: "",
        cpf : "",
        crp : "",
        email : "",
        name : "",
        phone : "",
        specialty: ""
  };
  
  ngOnInit() {
    // console.log(this.user);
  }
  close() {
    this.ref.close();
  }
  error: any = null;

  createUser(){
    this.doctorService.store(this.user).subscribe((response: RequestResult) =>{
    if(response.isFailed()){

    if(response.getResponse())
    this.error = response.getResponse().message;
      
      return;
    }
    this.toastService.success(
      'Usuario Criado con Sucesso',
      'Criação de Usuario'
    );
    this.close();

    console.log("xd")});
    console.log(this.user);
  }
}
