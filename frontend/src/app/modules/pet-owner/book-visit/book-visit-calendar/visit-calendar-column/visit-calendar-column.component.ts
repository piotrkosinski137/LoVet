import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {VisitReservationModalComponent} from "./visit-reservation-modal/visit-reservation-modal.component";
import {Router} from "@angular/router";
import {WorkingHour} from "../../../../doctor/working-hours/working-hours-manager/working-hour";

@Component({
  selector: 'app-visit-calendar-column',
  templateUrl: './visit-calendar-column.component.html',
  styleUrls: ['./visit-calendar-column.component.scss']
})
export class VisitCalendarColumnComponent implements OnInit {

  @Input()
  plusDays: number;

  @Input()
  workingHours: WorkingHour[];

  constructor(private dialog: MatDialog, private router: Router) {
  }

  ngOnInit() {
  }

  onVisitBookingClicked(workingHour: WorkingHour) {
    const dialogRef = this.dialog.open(VisitReservationModalComponent, {
      data: {
        visitBooking: workingHour,
        visitHour: this.getHour(workingHour)
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result.isSubmitted) {
        this.workingHours.filter(visitBooking => visitBooking.visitDate === result.visitBooking)[0].isBooked = true;
        this.router.navigate(['pet-owner/visits']);
      }
    });
  }

  getHour(booking: WorkingHour): string {
    let hour = booking.visitDate.getHours() + ':' + booking.visitDate.getMinutes()
    if (booking.visitDate.getMinutes() === 0) {
      hour = hour + '0'
    }
    return hour;
  }
}
