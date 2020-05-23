import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  saveBlank(visits: Date[]): Observable<any> {
    return this.http.post(this.BASE_URL + '/visits/doctor/new', {visits});
  }
}
