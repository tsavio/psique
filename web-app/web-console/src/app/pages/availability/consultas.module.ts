import { NgModule } from '@angular/core';
import {
  NbButtonModule,
  NbCardModule,
  NbUserModule,
  NbListModule,
  NbIconModule,
  NbDatepickerModule,
} from '@nebular/theme';

import { ThemeModule } from '../../@theme/theme.module';
import { FormsModule } from '@angular/forms';
import { ConsultasComponent } from './consultas.component';
import { NgxMaterialTimepickerModule } from 'ngx-material-timepicker';
import { Ng2SmartTableModule } from 'ng2-smart-table';

@NgModule({
  imports: [
    FormsModule,
    ThemeModule,
    NbCardModule,
    NbUserModule,
    NbDatepickerModule,
    Ng2SmartTableModule,
    NbButtonModule,
    NbListModule,
    NgxMaterialTimepickerModule,
    NbIconModule,
  ],
  declarations: [
      ConsultasComponent
  ],
})
export class ConsultasModule { }
