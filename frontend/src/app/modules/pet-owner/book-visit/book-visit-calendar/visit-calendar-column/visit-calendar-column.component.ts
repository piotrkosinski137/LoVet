import {Component, Input, OnInit} from '@angular/core';
import {VisitBooking} from "../../../model/visit-booking";
import {MatDialog} from "@angular/material/dialog";
import {VisitReservationModalComponent} from "./visit-reservation-modal/visit-reservation-modal.component";

@Component({
  selector: 'app-visit-calendar-column',
  templateUrl: './visit-calendar-column.component.html',
  styleUrls: ['./visit-calendar-column.component.scss']
})
export class VisitCalendarColumnComponent implements OnInit {

  @Input()
  plusDays: number;

  @Input()
  visitBookings: VisitBooking[];

  constructor(private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  onVisitBookingClicked(visitBooking: VisitBooking) {
    const dialogRef = this.dialog.open(VisitReservationModalComponent, {
      data: {
        visitBooking: visitBooking,
        visitHour: this.getHour(visitBooking)
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result.isSubmitted) {
        this.visitBookings.filter(visitBooking => visitBooking.date === result.visitBooking)[0].isBooked = true;
      }
    });
  }

  getHour(booking: VisitBooking): string {
    let hour = booking.date.getHours() + ':' + booking.date.getMinutes()
    if (booking.date.getMinutes() === 0) {
      hour = hour + '0'
    }
    return hour;
  }
}
