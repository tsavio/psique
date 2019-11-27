import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class ConsultationService {

    constructor(private http: HttpClient) { }

    private API = environment.API;

    getAll() {
        return this.http.get(`${this.API}/consultation`).pipe(take(1));
    }
    storeConsultation(data) {
        return this.http.post(`${this.API}/consultation`, data, {
            headers: {
                userId: JSON.parse(sessionStorage.getItem('user')).id
            }
        }).pipe(take(1));
    }

    updateATime(id: any) {
        return this.http.post(`${this.API}/availability/setUsing`, {id}).pipe(take(1));
    }
}