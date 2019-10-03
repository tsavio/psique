import { Component, OnInit, Input } from '@angular/core';
import { NbDialogRef, NbThemeService } from '@nebular/theme';

@Component({
  selector: 'b-modal-patient',
  templateUrl: './modal-patient.component.html',
  styleUrls: ['./modal-patient.component.scss']
})
export class ModalPatientComponent implements OnInit {

  constructor(protected ref: NbDialogRef<ModalPatientComponent>, private theme: NbThemeService) { }

  @Input() title: string;

  prefixCall = "https://hangouts.google.com/call/";
  generateRamdon = "gerar 9 letras aleatorias";
  sufixCall = "raaystieqjdojcqw26"+ this.generateRamdon +"?no_rd";

  urlCall = this.prefixCall + this.generateRamdon + this.sufixCall;

  data = null;
 
  ngOnInit() {
    console.log(this.title);
    this.data = JSON.parse(this.title);
  }

  close() {
    this.ref.close();
  }


}
