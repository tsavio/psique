import { PatientService } from './patient/patient.service';
import { PatientComponent } from './patient/patient.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';

@NgModule({
	declarations: [ AppComponent, PatientComponent ],
	imports: [ BrowserModule, HttpModule ],
	providers: [ PatientService ],
	bootstrap: [ AppComponent ]
})
export class AppModule {}
