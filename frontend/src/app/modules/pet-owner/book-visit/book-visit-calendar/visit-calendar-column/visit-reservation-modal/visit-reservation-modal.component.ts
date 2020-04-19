import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {VisitBooking} from "../../../../model/visit-booking";

@Component({
  selector: 'app-visit-reservation-modal',
  templateUrl: './visit-reservation-modal.component.html',
  styleUrls: ['./visit-reservation-modal.component.scss']
})
export class VisitReservationModalComponent implements OnInit {

  visitBooking: VisitBooking;
  visitHour: string;

  constructor(@Inject(MAT_DIALOG_DATA) private passedData: any) { }

  ngOnInit() {
    this.visitBooking = this.passedData.visitBooking;
    this.visitHour = this.passedData.visitHour;
  }

  onBookingSubmitted() {
    return {isSubmitted: true, visitBooking: this.visitBooking.date}
  }

  onBookingCancelled() {
    return {isSubmitted: false}
  }
}
