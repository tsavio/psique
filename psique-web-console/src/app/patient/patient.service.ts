import { Patient } from './patient';
import { Http, Response, ResponseOptions, Headers } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class PatientService {
	constructor(private _httpService: Http) {}
	getAllPatients(): Observable<Patient[]> {
		return this._httpService.get("http://localhost:4200/psique/api/patients").map((response: Response) => response.json()).catch(this.handleError);
	}
	private handleError(error: Response) {
		return Observable.throw(error);
	}
}
