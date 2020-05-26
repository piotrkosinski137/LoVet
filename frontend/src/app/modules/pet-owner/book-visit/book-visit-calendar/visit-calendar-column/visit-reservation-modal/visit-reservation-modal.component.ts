import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {WorkingHour} from "../../../../../doctor/working-hours/working-hours-manager/working-hour";

@Component({
  selector: 'app-visit-reservation-modal',
  templateUrl: './visit-reservation-modal.component.html',
  styleUrls: ['./visit-reservation-modal.component.scss']
})
export class VisitReservationModalComponent implements OnInit {

  workingHour: WorkingHour;
  visitHour: string;

  constructor(@Inject(MAT_DIALOG_DATA) private passedData: any) { }

  ngOnInit() {
    this.workingHour = this.passedData.visitBooking;
    this.visitHour = this.passedData.visitHour;
  }

  onBookingSubmitted() {
    return {isSubmitted: true, visitBooking: this.workingHour.visitDate}
  }

  onBookingCancelled() {
    return {isSubmitted: false}
  }
}
