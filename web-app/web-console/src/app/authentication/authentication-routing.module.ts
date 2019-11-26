import {  RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { NbAuthComponent } from '@nebular/auth';
import { AuthenticationComponent } from './authentication.component';

const routes: Routes = [
  {
    path: '',
    component: NbAuthComponent,
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
  
