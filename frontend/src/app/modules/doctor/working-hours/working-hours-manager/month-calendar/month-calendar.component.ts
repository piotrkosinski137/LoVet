import {Component, OnDestroy, OnInit} from '@angular/core';
import {WorkingHoursService} from "../../working-hours.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-month-calendar',
  templateUrl: './month-calendar.component.html',
  styleUrls: ['./month-calendar.component.scss']
})
export class MonthCalendarComponent implements OnInit, OnDestroy {

  monthDate: Date;
  monthDays: Date[] = [];
  gapNumbers: number[];
  subscription: Subscription;

  constructor(private workingHoursService: WorkingHoursService) {
  }

  ngOnInit() {
    this.subscription = this.workingHoursService.dateSelected.subscribe(date => {
      this.monthDate = date;
      this.getDaysInMonthUTC();
      this.calculateGapNumbers();
    });
  }

  getDaysInMonthUTC() {
    this.monthDays = [];
    let date = new Date(this.monthDate);
    while (date.getMonth() === this.monthDate.getMonth()) {
      this.monthDays.push(new Date(date));
      date.setDate(date.getDate() + 1);
    }
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  private calculateGapNumbers() {
    this.gapNumbers = this.monthDate.getDay() === 0 ? [] : [...Array(this.monthDate.getDay() -1).keys()];
  }

  dummyDate() {
    return new Date();
  }
}
