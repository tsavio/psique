import { PacienteComponent } from './paciente/paciente.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ECommerceComponent } from './e-commerce/e-commerce.component';
import { NotFoundComponent } from './miscellaneous/not-found/not-found.component';
import { ConfiguracaoComponent } from './configuracao/configuracao.component';
import { ConsultasComponent } from './consultas/consultas.component';
import { ProfileDoctorComponent } from './profile-doctor/profile-doctor.component';

const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: 'dashboard',
      component: DashboardComponent,
    },
    {
      path: 'paciente',
      component: PacienteComponent,
    },
    {
      path: 'profile-doctor',
      component: ProfileDoctorComponent,
    },
    {
      path: 'consultas',
      component: ConsultasComponent,
    },
    {
      path: '',
      redirectTo: 'dashboard',
      pathMatch: 'full',
    },
    {
      path: '**',
      component: NotFoundComponent,
    },
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
