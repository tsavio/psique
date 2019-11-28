import { Component, OnInit } from '@angular/core';
import { NbDateService, NbComponentStatus, NbComponentShape, NbComponentSize, NbToastrService } from '@nebular/theme';
import { DoctorService } from '../../services/doctor.service';
import { Key } from 'selenium-webdriver';
import * as moment from 'moment';

import { FormControl } from '@angular/forms';
import { EventEmitter } from 'events';

@Component({
  selector: 'ngx-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.scss']
})
export class ConsultasComponent implements OnInit {

  min: Date;
  max: Date;
  
  constructor(private doctorService: DoctorService, private toastService: NbToastrService, protected dateService: NbDateService<Date>) {
    this.min = this.dateService.addDay(this.dateService.today(), 0);
    this.max = this.dateService.addDay(this.dateService.today(), 5);
  }

  ngModelDate = moment().toDate();;
  ngModelTime;
  user;
  dateValue;
  pickerValue;

  statuses: NbComponentStatus[] = ['success'];
  shapes: NbComponentShape[] = ['rectangle'];
  sizes: NbComponentSize[] = ['tiny'];

  aTime = {};
  aTimes: any = null;
  settings = {
    columns: {
      date: {
        title: 'Data',
        sortDirection: 'asc'
      },
      hour: {
        title: 'Hora',
      }
    },
    actions: false
  };

  getAllATime() {
    this.doctorService.getAllATime().subscribe((response: any) => 
      this.aTimes = response.object
    );
  }

  saveDate(){
    this.aTime = {
      hour: moment(this.ngModelTime, ["h:mm A"]).format("HH:mm"),
      date: moment(this.ngModelDate).format('DD/MM/YYYY'),
      userId: this.user.id,
      userName: this.user.name
    };
    this.doctorService.storeATime(this.aTime).subscribe((response:any) => this.getAllATime());
    this.toastService.success(
      'Horário disponibilizado com sucesso',
      'Criação de disponibilidade de horário'
    );
  }

  timeSetListen(event){
    this.ngModelTime = event;
  }

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.getAllATime();
  }

}
