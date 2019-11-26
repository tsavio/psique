import { Component, OnInit } from '@angular/core';
import { NbDialogRef, NbDialogService } from '@nebular/theme';
import { DoctorService } from '../../services/doctor.service';


@Component({
  selector: 'ngx-profile-doctor',
  templateUrl: './profile-doctor.component.html',
  styleUrls: ['./profile-doctor.component.scss'],
  providers:[DoctorService]
})
export class ProfileDoctorComponent implements OnInit {
  
  constructor(private dialogService: NbDialogService, private doctorService:DoctorService) { }
  
  ngOnInit() {
    this.getAllATime();
  }
  
  
  aTime: any = null;
  doctor = JSON.parse(sessionStorage.getItem('user'));

  getAllATime() {
    this.doctorService.getAllATime().subscribe((response: any) => this.aTime = response.object);
  }
 
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
  
  
  
  
  
  
  
}
 
