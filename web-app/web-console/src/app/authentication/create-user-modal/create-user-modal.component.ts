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

  user: any = {
    login: "",
    password: "",
    cpf: "",
    crp: "",
    email: "",
    name: "",
    phone: "",
    specialty: ""
  };

  ngOnInit() {
  }
  close() {
    this.ref.close();
  }
  error: any = null;

  createUser() {
    if (this.user.login == "" || this.user.password == "" || this.user.cpf == "" || this.user.email == "" ||
      this.user.name == "" || this.user.phone == "" || this.user.crp == "" || this.user.specialty == "") {
      this.toastService.warning(
        'Usuário não pode ser criado com campos vazios !',
        'Falha ao criar Usuario'
      );
    }else {
      this.doctorService.store(this.user).subscribe((response: RequestResult) => {
        if (response.isFailed()) {

          if (response.getResponse())
            this.error = response.getResponse().message;

          return;
        }
        this.toastService.success(
          'Usuário Criado com Sucesso',
          'Criação de Usuário'
        );
        this.close();
      });
    }
  }
}
