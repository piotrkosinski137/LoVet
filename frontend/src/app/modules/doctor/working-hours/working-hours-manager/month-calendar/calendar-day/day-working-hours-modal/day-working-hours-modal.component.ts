import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {WorkingHour} from "../../../working-hour";

@Component({
  selector: 'app-day-working-hours-modal',
  templateUrl: './day-working-hours-modal.component.html',
  styleUrls: ['./day-working-hours-modal.component.scss']
})
export class DayWorkingHoursModalComponent implements OnInit {

  hours: WorkHourBooking[] = [];
  date: Date;

  constructor(@Inject(MAT_DIALOG_DATA) private passedData: any) {
  }

  ngOnInit() {
    this.date = this.passedData.date;
    this.prepareHours(this.passedData.bookedHours);
  }

  prepareHours(bookedHours: WorkingHour[]) {
    this.hours = [];
    this.date.setHours(9, 0, 0);
    while (this.date.getHours() <= 18) {
      this.hours.push(new WorkHourBooking(new Date(this.date), this.isSelected(new Date(this.date), bookedHours)));
      this.date.setMinutes(this.date.getMinutes() + 20);
    }
  }

  isSelected(workingDay: Date, bookedHours: WorkingHour[]) {
    return bookedHours.some((bookedHour: WorkingHour) => {
      return bookedHour.visitDate.getHours() === workingDay.getHours()
        && bookedHour.visitDate.getMinutes() == workingDay.getMinutes()
    });
  }

  minutesPeriodSelected(hourBooking: WorkHourBooking) {
    hourBooking.isSelected = !hourBooking.isSelected;
  }

  selectHour(selectedHour: number) {
    let selectedCounter = 0;
    let hoursToModify = this.hours.filter(period => period.hourDate.getHours() === selectedHour);

    hoursToModify.forEach(hour => {
      if (hour.isSelected) {
        selectedCounter++;
      }
    });

    if (selectedCounter == hoursToModify.length) {
      this.deselect(selectedHour, selectedHour);
    } else {
      this.select(selectedHour, selectedHour);
    }
  }

  select(from: number, to: number) {
    if (from !== to) {
      this.deselect(9, 18);
    }
    this.hours.forEach(period => {
      if (period.hourDate.getHours() >= from && period.hourDate.getHours() <= to) {
        period.isSelected = true;
      }
    });
  }


  deselect(from: number, to: number) {
    this.hours.forEach(period => {
      if (period.hourDate.getHours() >= from && period.hourDate.getHours() <= to) {
        period.isSelected = false;
      }
    });
  }

  modalSubmitted() {
    return {selectedHours: this.hours.filter(hour => hour.isSelected)
      .map(hour => hour.hourDate), day: this.date};
  }

  // selectWorkingDayType(): WorkingDayType {
  //   let selectedPeriods = this.hours.filter(period => period.isSelected);
  //   if (selectedPeriods.length === this.hours.length) {
  //     return WorkingDayType.ALL_DAY_SHIFT
  //   } else if (selectedPeriods.length === 0) {
  //     return WorkingDayType.NONE;
  //   } else if (selectedPeriods.length !== this.hours.length / 2) {
  //     return WorkingDayType.CUSTOM;
  //   } else if (selectedPeriods.every(period => period.hourDate.getHours() >= 9 && period.hourDate.getHours() <= 13)) {
  //     return WorkingDayType.MORNING_SHIFT
  //   } else if (selectedPeriods.every(period => period.hourDate.getHours() >= 14 && period.hourDate.getHours() <= 18)) {
  //     return WorkingDayType.EVENING_SHIFT
  //   }
  // }
}

class WorkHourBooking {

  constructor(private _hourDate: Date, private _isSelected?: boolean) {
  }

  get hourDate(): Date {
    return this._hourDate;
  }

  get isSelected(): boolean {
    return this._isSelected;
  }

  set hourDate(value: Date) {
    this._hourDate = value;
  }

  set isSelected(value: boolean) {
    this._isSelected = value;
  }
}

export enum WorkingDayType {
  MORNING_SHIFT = "Morning shift",
  EVENING_SHIFT = "Evening shift",
  ALL_DAY_SHIFT = "All day shift",
  CUSTOM = "Custom shift",
  NONE = ""
}
