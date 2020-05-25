import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from "../../../doctor/model/doctor";
import _ from "lodash";
import {VisitBooking} from "../../model/visit-booking";
import {WorkingHoursService} from "../../../doctor/working-hours/working-hours.service";

@Component({
  selector: 'app-book-visit-calendar',
  templateUrl: './book-visit-calendar.component.html',
  styleUrls: ['./book-visit-calendar.component.scss']
})
export class BookVisitCalendarComponent implements OnInit {

  @Input()
  doctors: Doctor[];
  sevenDaysArray = Array(7).map((x, i) => i);

  visitBookingMap: Map<number, VisitBooking[]>;

  constructor(private workingHoursService: WorkingHoursService) {
  }

  ngOnInit() {
    // console.log(new Date(Date.parse("1992-6-12")))
    // console.log(new Date(Date.parse("YYYY-MM-DDTHH:MM:SS")))
    // const doctorsVisits = this.doctors.map(doctor => this.getBookingsWithDoctorName(doctor.visitBookings, doctor.name))
    // .reduce((curr, next) => curr.concat(next), [])
    // this.visitBookingMap = _.groupBy(doctorsVisits, (visit: VisitBooking) => visit.date.getDate());
  }

  getBookingsWithDoctorName(visits: VisitBooking[], doctorName: string) {
    return visits.map(visit => new VisitBooking(visit.date, visit.isBooked, doctorName))
  }

  getVisitBookings(daysToAdd: number): VisitBooking[] {
    return this.visitBookingMap[new Date().getDate() + daysToAdd]
  }
}
