import {Component, OnDestroy, OnInit} from '@angular/core';
import {WorkingHoursService} from "../../working-hours.service";
import {Subscription} from "rxjs";
import {VisitService} from "../../../../../api/visit.service";
import {MessageService} from "../../../../../api/commons/message.service";
import {WorkingHourDaySubmitted} from "./calendar-day/calendar-day.component";
import {WorkingHour} from "../working-hour";

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
  workingHours: WorkingHour[] = [];

  constructor(private workingHoursService: WorkingHoursService, private visitService: VisitService,
              private messageService: MessageService) {
  }

  //it doesn't read already assigned workingHours
  ngOnInit() {
    this.subscription = this.workingHoursService.dateSelected.subscribe(date => {
      this.monthDate = date;
      this.selectWorkingHours();
      this.getDaysInMonthUTC();
      this.calculateGapNumbers();
    });
  }

  selectWorkingHours() {
    this.workingHoursService.getDoctorWorkingHoursByMonth(this.monthDate)
    .subscribe(workingHours => {
      this.workingHours = workingHours
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

  private calculateGapNumbers() {
    this.gapNumbers = this.monthDate.getDay() === 0 ? [] : [...Array(this.monthDate.getDay() - 1).keys()];
  }

  dummyDate() {
    return new Date();
  }

  getWorkingHoursBy(currentDate: Date) {
    return this.workingHours.filter(workingHour => {
      {
        return workingHour.visitDate.getFullYear() === currentDate.getFullYear() &&
          workingHour.visitDate.getMonth() === currentDate.getMonth() &&
          workingHour.visitDate.getDate() === currentDate.getDate()
      }
    });
  }

  onHoursSubmitted(event: WorkingHourDaySubmitted) {
    this.visitService.saveBlank(event).subscribe(() => {
        this.selectWorkingHours();
      },
      error => this.messageService.error(error.error?.errorCode));
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
