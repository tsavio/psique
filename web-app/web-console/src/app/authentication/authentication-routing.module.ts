import {  RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { NbAuthComponent } from '@nebular/auth';
import { AuthenticationComponent } from './authentication.component';
import { AuthBgComponent } from './auth-bg/auth-bg.component';

const routes: Routes = [
  {
    path: '',
    component: AuthBgComponent,
    children:[{
        path: 'login',
        component: AuthenticationComponent
    },{ path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: '**', redirectTo: 'login' },

    ]
  },
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth' },
];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
  })
  export class AuthenticationRoutingModule {
  }
  
