import {NgModule} from "@angular/core";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "../../auth/auth-interceptor.service";
import {WorkingHoursManagerComponent} from './working-hours/working-hours-manager/working-hours-manager.component';
import {DoctorRoutingModule} from "./doctor-routing.module";
import {MonthPickerComponent} from './working-hours/working-hours-manager/month-picker/month-picker.component';
import {MaterialModule} from "../../material.module";
import {ReactiveFormsModule} from "@angular/forms";
import {MatNativeDateModule} from "@angular/material/core";
import { MonthCalendarComponent } from './working-hours/working-hours-manager/month-calendar/month-calendar.component';
import {CommonModule} from "@angular/common";
import {GetDatePipe} from "./working-hours/get-month.pipe";
import { CalendarDayComponent } from './working-hours/working-hours-manager/month-calendar/calendar-day/calendar-day.component';
import { DayWorkingHoursModalComponent } from './working-hours/working-hours-manager/month-calendar/calendar-day/day-working-hours-modal/day-working-hours-modal.component';

@NgModule({
  imports: [
    DoctorRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    CommonModule
  ],
  entryComponents: [
    DayWorkingHoursModalComponent
  ],
  declarations: [
    WorkingHoursManagerComponent,
    MonthPickerComponent,
    MonthCalendarComponent,
    GetDatePipe,
    CalendarDayComponent,
    DayWorkingHoursModalComponent,
    GetDatePipe
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  exports: []
})
export class DoctorModule {
}
