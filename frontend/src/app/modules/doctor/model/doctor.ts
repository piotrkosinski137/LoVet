import {VisitBooking} from "../../pet-owner/model/visit-booking";

export class Doctor {
  constructor(private _name: string, private _visitBookings: VisitBooking[]) {
  }

  get visitBookings(): VisitBooking[] {
    return this._visitBookings;
  }

  get name(): string {
    return this._name;
  }
}
