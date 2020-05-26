import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from "../../../doctor/model/doctor";
import {WorkingHoursService} from "../../../doctor/working-hours/working-hours.service";
import {WorkingHour} from "../../../doctor/working-hours/working-hours-manager/working-hour";
import {reduce} from "rxjs/operators";

@Component({
  selector: 'app-book-visit-calendar',
  templateUrl: './book-visit-calendar.component.html',
  styleUrls: ['./book-visit-calendar.component.scss']
})
export class BookVisitCalendarComponent implements OnInit {

  @Input()
  doctors: Doctor[];
  sevenDaysArray = Array(7).map((x, i) => i);

  visitBookingMap: Map<number, WorkingHour[]>;

  constructor(private workingHoursService: WorkingHoursService) {
  }

  ngOnInit() {
    // console.log(new Date(Date.parse("1992-6-12")))
    // console.log(new Date(Date.parse("YYYY-MM-DDTHH:MM:SS")))
    this.doctors.forEach(doctor => this.getBookingsBy(doctor.id))
  }

  getBookingsBy(doctorId: string) {
    return this.workingHoursService.getDoctorWorkingHoursByWeek(new Date(), doctorId)
    .pipe(reduce((curr, next) => curr.concat(next), []))
    .subscribe((workingHours: WorkingHour[]) => {
      this.visitBookingMap = (workingHours.reduce((r, a) => {
        r[a.visitDate.getDate()] = [...r[a.visitDate.getDate()] || [], a];
        return r;
      }, {}) as Map<number, WorkingHour[]>);
    })
  }

  getWorkingHours(daysToAdd: number): WorkingHour[] {
    if(this.visitBookingMap && this.visitBookingMap[new Date().getDate() + daysToAdd]) {
      return (this.visitBookingMap[new Date().getDate() + daysToAdd] as WorkingHour[])
    }
  }
}
