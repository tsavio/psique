import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { RequestResult } from '../models/RequestResult';

@Component({
  selector: 'ngx-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.scss']
})
export class AuthenticationComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }
    
  authenticate : object = {
    login: "",
    password:""
  };

  setupError = {
    error: false,
    message: ""
  }

  ngOnInit() {
    sessionStorage.clear();
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
}
