import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  NbCardModule,
  NbAlertModule,
  NbDialogModule,
  NbInputModule,
  NbButtonModule,
  NbIconModule,
} from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { FormsModule }   from '@angular/forms';
import { AuthenticationComponent } from './authentication.component';
import { NbAuthModule } from '@nebular/auth';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { CreateUserModalComponent } from './create-user-modal/create-user-modal.component';

@NgModule({
  imports: [
    AuthenticationRoutingModule,
    FormsModule,
    ThemeModule,
    NbCardModule,
    NbAuthModule,
    NbAlertModule,
    NbDialogModule.forRoot(),
    NbInputModule,
    NbButtonModule,
    NbIconModule
  ],
  declarations: [
      AuthenticationComponent,
      CreateUserModalComponent,
  ],
  entryComponents: [CreateUserModalComponent, AuthenticationComponent]
})
export class AuthenticateModule { }
