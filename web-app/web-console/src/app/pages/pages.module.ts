import { ChartsModule } from './charts/charts.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgModule } from '@angular/core';
import { NbMenuModule, NbIconModule, NbInputModule } from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { PacienteModule } from './paciente/paciente.module';
import { ConsultasComponent } from './availability/consultas.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { NbCardModule, NbDatepickerModule, NbButtonModule, NbSelectModule } from '@nebular/theme';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { ProfileDoctorComponent } from './profile-doctor/profile-doctor.component';
import { FormsModule } from './forms/forms.module';
import { ConsultasModule } from './availability/consultas.module';

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    NbMenuModule,
    DashboardModule,
    ECommerceModule,
    MiscellaneousModule,
    Ng2SmartTableModule,
    FormsModule,
    PacienteModule,
    NbInputModule,
    NbCardModule, 
    NbDatepickerModule, 
    NbButtonModule,
    NbSelectModule,
    NbIconModule,
    ConsultasModule,
    DashboardModule
  ],
  declarations: [
    PagesComponent,
    ConfiguracaoComponent,
    ConsultationComponent,
    ProfileDoctorComponent,
  ],
})
export class PagesModule {
}
