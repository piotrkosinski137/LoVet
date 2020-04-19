import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-visit-calendar-column-date',
  templateUrl: './visit-calendar-column-date.component.html',
  styleUrls: ['./visit-calendar-column-date.component.scss']
})
export class VisitCalendarColumnDateComponent implements OnInit {

  @Input()
  plusDays: number;

  constructor() { }

  ngOnInit() {
  }

  getDayName(plusDays: number) {
    let date = new Date();
    date.setDate(date.getDate() + plusDays);
    return date.toLocaleDateString('en-En', {weekday: 'long'});
  }

  getDate(plusDays: number) {
    let date = new Date();
    date.setDate(date.getDate() + plusDays);
    return date.getDate() + ' ' + date.toLocaleString('en-En', {month: 'long'});
  }
}
