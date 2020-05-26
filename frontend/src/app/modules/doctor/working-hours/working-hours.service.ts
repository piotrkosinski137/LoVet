import {Injectable} from '@angular/core';
import {Observable, Subject} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {map} from "rxjs/operators";
import {WorkingHour} from "./working-hours-manager/working-hour";

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

  public getDoctorWorkingHoursByWeek(startDate: Date, doctorId: string): Observable<WorkingHour[]> {
    const params = new HttpParams().append('startDate', startDate.toLocaleDateString())
    return this.http.get<WorkingHour[]>(this.BASE_URL + '/visits/doctor/' + doctorId, {params})
    .pipe(map(response => this.convertToWorkingHours(response)))
  }

  private convertToWorkingHours(data: any[]) {
    return data.map(result => new WorkingHour(new Date(result.visitDate), result.isBooked));
  }
}
