import { PatientService } from './../../services/patient.service';
import { Component, OnInit } from '@angular/core';
import { NbDateService, NbComponentStatus, NbComponentShape, NbComponentSize } from '@nebular/theme';
import { ConsultationService } from '../../services/consultation.service';
import { DoctorService } from '../../services/doctor.service';
import { Key } from 'selenium-webdriver';

@Component({
    selector: 'ngx-consultation',
    templateUrl: './consultation.component.html',
    styleUrls: ['./consultation.component.scss']
})

export class ConsultationComponent implements OnInit {

    constructor(private doctorService: DoctorService, private consultationService: ConsultationService, private patientService: PatientService) { }

    consultations: any = null;
    patients: any = null;
    aTimes: any = null;

    patient;
    aTime;

    statuses: NbComponentStatus[] = ['success'];

    settings = {
        columns: {
            patientName: {
                title: 'Nome',
            },
            date: {
                title: 'Data',
            },
            hour: {
                title: 'Hora',
            }
        },
        actions: false
    };

    getAllPacients() {
        this.patientService.getAll().subscribe((response: any) => this.patients = response.object);
    }

    getAllATime() {
        this.doctorService.getAllATime().subscribe((response: any) => this.aTimes = response.object);
    }

    getAll() {
        this.consultationService.getAll().subscribe((response: any) => this.consultations = response.object);
    }

    saveConsultation(){
        console.log(this.patient)
        console.log(this.aTime)
    }

    ngOnInit() {
        this.getAll();
        this.getAllPacients();
        this.getAllATime();
    }

}
