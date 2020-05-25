import {Injectable} from '@angular/core';
import {Doctor} from "../modules/doctor/model/doctor";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  getDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.BASE_URL + '/doctors/overview');
  }
}
