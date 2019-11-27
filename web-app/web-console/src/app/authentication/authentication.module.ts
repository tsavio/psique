import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  NbCardModule,
  NbAlertModule,
  NbDialogModule,
  NbInputModule,
  NbButtonModule,
  NbIconModule,
  NbLayoutModule,
} from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { FormsModule }   from '@angular/forms';
import { AuthenticationComponent } from './authentication.component';
import { NbAuthModule } from '@nebular/auth';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { CreateUserModalComponent } from './create-user-modal/create-user-modal.component';
import { AuthBgComponent } from './auth-bg/auth-bg.component';

@NgModule({
  imports: [
    AuthenticationRoutingModule,
    FormsModule,
    ThemeModule,
    NbCardModule,
    NbAuthModule,
    NbLayoutModule,
    NbAlertModule,
    NbDialogModule.forRoot(),
    NbInputModule,
    NbButtonModule,
    NbIconModule
  ],
  declarations: [
    AuthBgComponent,
      AuthenticationComponent,
      CreateUserModalComponent,
      AuthBgComponent,
  ],
  entryComponents: [CreateUserModalComponent, AuthenticationComponent]
})
export class AuthenticateModule { }
