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
    user;
    consultation = {};
    patient;
    aTime;
    atimeid;

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

    saveConsultation() {
        this.consultation = {
            hour: this.aTime.hour,
            date: this.aTime.date,
            patientId: this.patient.id,
            patientName: this.patient.name,
            doctorId: this.user.id,
            doctorName: this.user.name
        };
        this.consultationService.storeConsultation(this.consultation).subscribe((response: any) => this.getAll());
        this.consultationService.updateATime(this.aTime.id).subscribe((response: any) => this.getAllATime());
    }

    ngOnInit() {
        this.user = JSON.parse(sessionStorage.getItem('user'));
        this.getAll();
        this.getAllPacients();
        this.getAllATime();
    }

}
