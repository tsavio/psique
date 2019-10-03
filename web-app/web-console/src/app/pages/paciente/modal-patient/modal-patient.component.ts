import { Component, OnInit, Input } from '@angular/core';
import { NbDialogRef, NbThemeService } from '@nebular/theme';
import { hangoutKey }  from '../../../config/hangoutKey';
@Component({
  selector: 'b-modal-patient',
  templateUrl: './modal-patient.component.html',
  styleUrls: ['./modal-patient.component.scss']
})
export class ModalPatientComponent implements OnInit {

  constructor(protected ref: NbDialogRef<ModalPatientComponent>, private theme: NbThemeService) { }

  @Input() title: string;

  data = null;
  
  ngOnInit() {
    this.data = JSON.parse(this.title);
  }

  close() {
    this.ref.close();
  }
  
  generateCallKey() {
    var letras = 'abcdefghiklmnopqrstuvwxyz';
    var key = '';
    for (var i = 0; i < 9; i++) {
      var rnum = Math.floor(Math.random() * letras.length);
      key += letras.substring(rnum, rnum + 1);
    }
    return key;
  }

  openCall(){
    var key = this.generateCallKey();
    return window.open("https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye");
  }
}
