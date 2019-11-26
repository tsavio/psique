import { Component, OnInit } from '@angular/core';
import { NbDateService, NbComponentStatus, NbComponentShape, NbComponentSize } from '@nebular/theme';
import { DoctorService } from '../../services/doctor.service';
import { Key } from 'selenium-webdriver';

@Component({
  selector: 'ngx-consultas',
  templateUrl: './consultas.component.html',
  styleUrls: ['./consultas.component.scss']
})
export class ConsultasComponent implements OnInit {

  min: Date;
  max: Date;
  
  constructor(private doctorService: DoctorService, protected dateService: NbDateService<Date>) {
    this.min = this.dateService.addDay(this.dateService.today(), 0);
    this.max = this.dateService.addDay(this.dateService.today(), 5);
  }

  statuses: NbComponentStatus[] = ['success'];
  shapes: NbComponentShape[] = ['rectangle'];
  sizes: NbComponentSize[] = ['tiny'];

  aTime: any = null;

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

  doctors: any = null;

  getAllATime() {
    this.doctorService.getAllATime().subscribe((response: any) => this.aTime = response.object);
  }

  ngOnInit() {
    this.getAllATime();
  }

}
