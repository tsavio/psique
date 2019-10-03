import { NbDialogService } from '@nebular/theme';
import { Component, OnInit, Input } from '@angular/core';
import { ModalPatientComponent } from '../modal-patient/modal-patient.component';
import { __values } from 'tslib';

@Component({
  selector: 'ngx-paciente-name',
  templateUrl: './paciente-name.component.html',
  styleUrls: ['./paciente-name.component.scss']
})
export class PacienteNameComponent implements OnInit {
 

  constructor( private dialogService: NbDialogService) { }

  @Input() value;
  @Input() rowData;
  ngOnInit() {
  }
    
  openPacientDetails(data){
    this.dialogService.open(ModalPatientComponent,{
      context:{
        title: JSON.stringify(this.rowData)
      }
    });
  }

}
