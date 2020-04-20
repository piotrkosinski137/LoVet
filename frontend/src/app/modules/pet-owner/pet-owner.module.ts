import {NgModule} from "@angular/core";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "../../auth/auth-interceptor.service";
import {MaterialModule} from "../../material.module";
import {CommonModule} from "@angular/common";
import {PetOwnerRoutingModule} from "./pet-owner-routing.module";
import {BookVisitComponent} from './book-visit/book-visit.component';
import {MatTabsModule} from "@angular/material/tabs";
import {BookVisitCalendarComponent} from './book-visit/book-visit-calendar/book-visit-calendar.component';
import {VisitCalendarColumnComponent} from './book-visit/book-visit-calendar/visit-calendar-column/visit-calendar-column.component';
import {VisitReservationModalComponent} from './book-visit/book-visit-calendar/visit-calendar-column/visit-reservation-modal/visit-reservation-modal.component';
import {VisitCalendarColumnDateComponent} from './book-visit/book-visit-calendar/visit-calendar-column/visit-calendar-column-date/visit-calendar-column-date.component';
import {PetsDashboardComponent} from './pets-dashboard/pets-dashboard.component';
import {VisitsDashboardComponent} from './visits-dashboard/visits-dashboard.component';
import {PetCardComponent} from './pets-dashboard/pet-card/pet-card.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AddPetModalComponent} from './pets-dashboard/add-pet-modal/add-pet-modal.component';
import {PetVisitHistoryComponent} from "./pets-dashboard/pet-visit-history/pet-visit-history.component";

@NgModule({
  imports: [
    PetOwnerRoutingModule,
    MaterialModule,
    CommonModule,
    MatTabsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    VisitReservationModalComponent,
    AddPetModalComponent
  ],
  declarations: [BookVisitComponent, BookVisitCalendarComponent, VisitCalendarColumnComponent,
    VisitReservationModalComponent, VisitCalendarColumnDateComponent, PetsDashboardComponent,
    VisitsDashboardComponent, PetCardComponent, AddPetModalComponent, PetVisitHistoryComponent],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  exports: []
})
export class PetOwnerModule {
}
