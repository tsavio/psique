import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgModule } from '@angular/core';
import { NbMenuModule, NbIconModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { PacienteModule } from './paciente/paciente.module';
import { ConsultasComponent } from './consultas/consultas.component';
import { NbCardModule, NbDatepickerModule, NbButtonModule, NbSelectModule } from '@nebular/theme';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { ProfileDoctorComponent } from './profile-doctor/profile-doctor.component';

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DashboardModule,
    ECommerceModule,
    MiscellaneousModule,
    Ng2SmartTableModule,
    PacienteModule,
    NbCardModule, 
    NbDatepickerModule, 
    NbButtonModule,
    NbSelectModule,
    NgxMaterialTimepickerModule,
    NbIconModule
  ],
  declarations: [
    PagesComponent,
    ConfiguracaoComponent,
    ConsultasComponent,
    ProfileDoctorComponent,
  ],
})
export class PagesModule {
}
