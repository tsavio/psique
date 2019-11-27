import { RequestResult } from './../models/RequestResult';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take, map, catchError } from 'rxjs/operators';
import { of as observableOf } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DoctorService {

    constructor(private http: HttpClient) { }

    private API = environment.API;

    getAll() {
        return this.http.get(`${this.API}/doctor`, {
            headers: {
                userId: JSON.parse(sessionStorage.getItem('user')).id
            }
        }).pipe(take(1));
    }
    getById(id) {
        return this.http.get(`${this.API}/doctor/${id}`).pipe(take(1));
    }
    store(data) {
        return this.http.post(`${this.API}/auth/register`, data, {
            headers: {
                userId: JSON.parse(sessionStorage.getItem('user')).id
            }
        }).pipe(take(1), map(res => new RequestResult(true, res)), catchError(res => observableOf(new RequestResult(false, res))));
    }
    update(id) {
        return this.http.post(`${this.API}/doctor`, id).pipe(take(1));
    }
    destroy(id) {
        return this.http.put(`${this.API}/doctor`, id).pipe(take(1));
    }
    getAllATime() {
        return this.http.get(`${this.API}/availability`, {
            headers: {
                userId: JSON.parse(sessionStorage.getItem('user')).id
            }
        }).pipe(take(1));
    }
    storeATime(data) {
        return this.http.post(`${this.API}/availability`, data, {
            headers: {
                userId: JSON.parse(sessionStorage.getItem('user')).id
            }
        }).pipe(take(1));
    }

}