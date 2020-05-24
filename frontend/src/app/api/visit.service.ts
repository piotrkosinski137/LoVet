import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {WorkingHourDaySubmitted} from "../modules/doctor/working-hours/working-hours-manager/month-calendar/calendar-day/calendar-day.component";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  saveBlank(dto: WorkingHourDaySubmitted): Observable<any> {
    return this.http.post(this.BASE_URL + '/visits/doctor/new', {visits: dto.selectedHours,
      day: dto.day.toLocaleDateString()});
  }
}
