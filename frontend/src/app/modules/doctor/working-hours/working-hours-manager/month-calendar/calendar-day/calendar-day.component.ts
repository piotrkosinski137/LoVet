import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {DayWorkingHoursModalComponent} from "./day-working-hours-modal/day-working-hours-modal.component";

@Component({
  selector: 'app-calendar-day',
  templateUrl: './calendar-day.component.html',
  styleUrls: ['./calendar-day.component.scss']
})
export class CalendarDayComponent implements OnInit {

  @Input()
  date: Date;
  @Input()
  workingHours: any[] = [];
  @Output()
  hoursSubmitted = new EventEmitter<WorkingHourDaySubmitted>()

  constructor(private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  onDayClicked() {
    const dialogRef = this.dialog.open(DayWorkingHoursModalComponent, {
      data: {
        date: this.date,
        bookedHours: this.workingHours
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.hoursSubmitted.emit(result);
      }
    });
  }
}

export interface WorkingHourDaySubmitted {
  selectedHours: Date[],
  day: Date;
}
