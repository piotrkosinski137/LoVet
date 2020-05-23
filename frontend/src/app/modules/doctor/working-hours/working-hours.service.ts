import {Injectable} from '@angular/core';
import {Observable, Subject} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class WorkingHoursService {

  dateSelected = new Subject<Date>();
  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  public getWorkingHoursByMonth(monthDate: Date): Observable<any> {
    const params = new HttpParams().append('monthDate', monthDate.toLocaleDateString())
    return this.http.get(this.BASE_URL + '/visits/doctor', {params})
  }
}
