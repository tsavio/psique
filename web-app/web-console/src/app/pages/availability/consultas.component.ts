import { Component, OnInit } from '@angular/core';
import { NbDateService, NbComponentStatus, NbComponentShape, NbComponentSize } from '@nebular/theme';
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

  userSession = JSON.parse(sessionStorage.getItem('user'));

  constructor(private doctorService: DoctorService, protected dateService: NbDateService<Date>) {
    this.min = this.dateService.addDay(this.dateService.today(), 0);
    this.max = this.dateService.addDay(this.dateService.today(), 5);
  }

  ngModelDate = moment().toDate();;
  ngModelTime;

  dateValue;
  pickerValue;

  statuses: NbComponentStatus[] = ['success'];
  shapes: NbComponentShape[] = ['rectangle'];
  sizes: NbComponentSize[] = ['tiny'];
  // timeSetListen: EventEmitter = new EventEmitter();
  aTime = {};
  aTimes: any = null;
  settings = {
    columns: {
      date: {
        title: 'Data',
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
      hour: this.ngModelTime,
      date: moment(this.ngModelDate).format('DD/MM/YYYY'),
      userId: this.user.id,
    };
    this.doctorService.store(this.aTime).subscribe((response:any) => this.getAllATime());
  }

  timeSetListen(event){
    this.ngModelTime = event;
  }
  user;

  ngOnInit() {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    this.getAllATime();
  }

}
