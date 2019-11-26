import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take, map, catchError } from 'rxjs/operators';
import { RequestResult } from '../models/RequestResult';
import { Observable, of as observableOf } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }

  private API = environment.API + '/auth';
  login(data){
    return this.http.post(`${this.API}/login`, data).pipe(take(1),
      map((o:any) => {
        return new RequestResult(true, o);
        
      }),
    catchError(err => observableOf(new RequestResult(false, err)))
    );
  }
  register(data) {
    return this.http.post(`${this.API}/register`, data).pipe(take(1),
      map((o:any) => {
        return new RequestResult(true, o);
        
      }),
    catchError(err => observableOf(new RequestResult(false, err)))
    );
}
}
