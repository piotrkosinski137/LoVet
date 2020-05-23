import {Component, OnDestroy, OnInit} from '@angular/core';
import {WorkingHoursService} from "../../working-hours.service";
import {Subscription} from "rxjs";
import {VisitService} from "../../../../../api/visit.service";
import {MessageService} from "../../../../../api/commons/message.service";

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
  bookedWorkingHours: any[] = [];

  constructor(private workingHoursService: WorkingHoursService, private visitService: VisitService,
              private messageService: MessageService) {
  }

  ngOnInit() {
    this.subscription = this.workingHoursService.dateSelected.subscribe(date => {
      this.monthDate = date;
      this.selectWorkingHours();

      this.getDaysInMonthUTC();
      this.calculateGapNumbers();
    });
  }

  selectWorkingHours() {
    this.workingHoursService.getWorkingHoursByMonth(this.monthDate).subscribe(dates => this.bookedWorkingHours = dates.workingHours);
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
    this.gapNumbers = this.monthDate.getDay() === 0 ? [] : [...Array(this.monthDate.getDay() - 1).keys()];
  }

  dummyDate() {
    return new Date();
  }

  getWorkingHoursBy(currentDate: Date) {

    return this.bookedWorkingHours.filter(date => {
      {
        return date.year === currentDate.getFullYear() &&
          date.monthValue === currentDate.getMonth() + 1 &&
          date.dayOfMonth === currentDate.getDate()
      }
    });
  }

  onHoursSubmitted(selectedHours: Date[]) {
    this.visitService.saveBlank(selectedHours).subscribe(() => {
        this.selectWorkingHours();
      },
      error => this.messageService.error(error.error?.errorCode));
  }
}
