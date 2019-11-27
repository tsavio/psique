import { NbDialogService } from '@nebular/theme';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { RequestResult } from '../models/RequestResult';
import { CreateUserModalComponent } from './create-user-modal/create-user-modal.component';

@Component({
  selector: 'ngx-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router, private dialogService: NbDialogService) { }
    
  authenticate : object = {
    login: "",
    password:""
  };

  setupError = {
    error: false,
    message: ""
  }

  ngOnInit() {
    if(sessionStorage.getItem('user')){
      this.router.navigate(['/pages/dashboard']);
    }else{
      sessionStorage.clear();
    }
  }

  login(){
    this.authService.login(this.authenticate).subscribe((res:RequestResult) => {
      if(res.isFailed()){
        this.authenticate = {
          login: "",
          password:""
        };
        // console.log(res.getResponse());
        this.setupError.error = true;
        this.setupError.message = res.getResponse().error.message;
        return;
      }
      sessionStorage.setItem('user', JSON.stringify(res.getResponse()));
      this.router.navigate(['/pages/dashboard']);
    });
  }

  openCreateUserModal(){
    this.dialogService.open(CreateUserModalComponent,{
      hasScroll: true
    });
  }
}
