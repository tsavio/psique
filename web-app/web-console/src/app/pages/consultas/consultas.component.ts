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

  constructor(private doctorService:DoctorService,protected dateService: NbDateService<Date>) {
    this.min = this.dateService.addDay(this.dateService.today(), -5);
    this.max = this.dateService.addDay(this.dateService.today(), 5);
  }
  
  min: Date;
  max: Date;

  statuses: NbComponentStatus[] = [ 'success'];
  shapes: NbComponentShape[] = [ 'rectangle' ];
  sizes: NbComponentSize[] = [ 'tiny' ];

  doctors : any = null;

  getAllDoctors(){
    this.doctorService.getAll().subscribe((response:any) => this.doctors = response.object);
  }

  ngOnInit(){
    this.getAllDoctors();
  }

}
