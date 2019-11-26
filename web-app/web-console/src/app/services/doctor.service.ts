import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class DoctorService {

    constructor(private http: HttpClient) { }

    private API = environment.API;

    getAll() {
        return this.http.get(`${this.API}/doctor`).pipe(take(1));
    }
    getById(id) {
        return this.http.get(`${this.API}/doctor/${id}`).pipe(take(1));
    }
    store(data) {
        return this.http.post(`${this.API}/doctor`, data).pipe(take(1));
    }
    update(id) {
        return this.http.post(`${this.API}/doctor`, id).pipe(take(1));
    }
    destroy(id) {
        return this.http.put(`${this.API}/doctor`, id).pipe(take(1));
    }
    getAllATime() {
        return this.http.get(`${this.API}/availability`).pipe(take(1));
    }

}