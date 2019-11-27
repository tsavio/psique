import { Component, OnInit } from '@angular/core';
import { NbDateService, NbComponentStatus, NbComponentShape, NbComponentSize } from '@nebular/theme';
import { DoctorService } from '../../services/doctor.service';
import { Key } from 'selenium-webdriver';
import { FormControl } from '@angular/forms';
import * as moment from 'moment';

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

  formControl = new FormControl(moment());
  ngModelDate = moment();

  dateValue;
  pickerValue;

  statuses: NbComponentStatus[] = ['success'];
  shapes: NbComponentShape[] = ['rectangle'];
  sizes: NbComponentSize[] = ['tiny'];

  aTime = {};
  aTimes: any = null;
  settings = {
    columns: {
      name: {
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

  getAllATime() {
    this.doctorService.getAllATime().subscribe((response: any) => this.aTimes = response.object);
  }

  saveDate(){
    console.log(this.ngModelDate)
    console.log(this.pickerValue)
    // this.doctorService.store(this.aTime).subscribe((response:any) => this.getAllATime());
  }

  ngOnInit() {
    this.getAllATime();
  }

}
