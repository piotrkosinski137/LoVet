import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import * as _moment from 'moment';
// @ts-ignore
import {default as _rollupMoment, Moment} from 'moment';
import {WorkingHoursService} from "../../working-hours.service";

const moment = _rollupMoment || _moment;

@Component({
  selector: 'app-month-picker',
  templateUrl: './month-picker.component.html',
  styleUrls: ['./month-picker.component.scss']
})
export class MonthPickerComponent implements OnInit {

  date = new FormControl(moment());

  constructor(private workingHoursService: WorkingHoursService) {
  }

  ngOnInit() {
  }

  chosenMonthHandler(normalizedMonth: Moment, datepicker: any) {
    this.workingHoursService.dateSelected.next(moment(normalizedMonth).toDate());
    datepicker.close();
  }

  getToday() {
    return new Date()
  }
}
