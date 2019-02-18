import { Component, OnInit } from '@angular/core';
import { Patient } from './patient';
import { PatientService } from './patient.service';

@Component({
	selector: 'app-patient',
	templateUrl: './patient.component.html',
	styleUrls: [ './patient.component.css' ]
})
export class PatientComponent implements OnInit {
	patients: Patient[];
	constructor(private _patientService: PatientService) {}
	ngOnInit(): void {
		this.getPatients();
	}
	getPatients(): void {
		this._patientService.getAllPatients().subscribe(
			(patientData) => {
				(this.patients = patientData), console.log(patientData);
			},
			(error) => {
				console.log(error);
			}
		);
	}
}
