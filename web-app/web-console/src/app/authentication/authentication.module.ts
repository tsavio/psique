import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  NbCardModule,
  NbAlertModule,
} from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { FormsModule }   from '@angular/forms';
import { AuthenticationComponent } from './authentication.component';
import { NbAuthModule } from '@nebular/auth';
import { AuthenticationRoutingModule } from './authentication-routing.module';

@NgModule({
  imports: [
    AuthenticationRoutingModule,
    FormsModule,
    ThemeModule,
    NbCardModule,
    NbAuthModule,
    NbAlertModule,
  ],
  declarations: [
      AuthenticationComponent,
  ],
})
export class AuthenticateModule { }
