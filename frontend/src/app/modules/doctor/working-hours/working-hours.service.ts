import {Injectable} from '@angular/core';
import {Observable, Subject} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {WorkingHour} from "./working-hours-manager/month-calendar/month-calendar.component";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class WorkingHoursService {

  dateSelected = new Subject<Date>();
  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  public getDoctorWorkingHoursByMonth(monthDate: Date): Observable<WorkingHour[]> {
    const params = new HttpParams().append('monthDate', monthDate.toLocaleDateString())
    return this.http.get<WorkingHour[]>(this.BASE_URL + '/visits/doctor', {params})
    .pipe(map(response => this.convertToWorkingHours(response)))
  }

  public getWeekWorkingHoursFromDoctor(startDate: Date, doctorId: string): Observable<WorkingHour[]> {
    const params = new HttpParams().append('startDate', startDate.toLocaleDateString())
    return this.http.get<WorkingHour[]>(this.BASE_URL + '/visits/doctor/' + doctorId, {params})
  }

  private convertToWorkingHours(data: any[]) {
    return data.map(result => new WorkingHour(new Date(result.visitDate), result.isBooked));
  }
}
