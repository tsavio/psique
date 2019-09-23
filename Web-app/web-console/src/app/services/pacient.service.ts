import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PacientService {

  constructor(private http:HttpClient) { }

  private API = environment.API;
  getAll(){
    return this.http.get(`${this.API}/pacient`).pipe(take(1));
  }
}
