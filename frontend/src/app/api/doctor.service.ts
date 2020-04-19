import {Injectable} from '@angular/core';
import {Doctor} from "../modules/doctor/model/doctor";
import {Observable, of} from "rxjs";
import {VisitBooking} from "../modules/pet-owner/model/visit-booking";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  doctors: Doctor[] = [
    new Doctor("Adrianna Nowakowska", [
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 10, 0), true),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 10, 30), true),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 11, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 11, 30), true),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 12, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 12, 30), true),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 13, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 13, 30), true),

      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 10, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 10, 30), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 11, 30), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 12, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 12, 30), true),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 13, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 2, 13, 30), true),
    ]),
    new Doctor("Piotr Kosiński", [
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 5, 10, 0), false),
    ]),
    new Doctor("Doctor Dollitle", [
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 1, 13, 0), false),
      new VisitBooking(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate() + 1, 13, 30), true),
    ])];

  constructor() {
  }

  getDoctors(): Observable<Doctor[]> {
    return of(this.doctors);
  }
}
