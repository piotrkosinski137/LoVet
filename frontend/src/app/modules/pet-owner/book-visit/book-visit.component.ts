import { Component, OnInit } from '@angular/core';
import {DoctorService} from "../../../api/doctor.service";
import {Observable} from "rxjs";
import {Doctor} from "../../doctor/model/doctor";

@Component({
  selector: 'app-book-visit',
  templateUrl: './book-visit.component.html',
  styleUrls: ['./book-visit.component.scss']
})
export class BookVisitComponent implements OnInit {

  doctors$: Observable<Doctor[]>;

  constructor(private doctorService: DoctorService) { }

  ngOnInit() {
    this.doctors$ = this.doctorService.getDoctors();
  }

  dummyDoctor() {
    return new Doctor('elos', []);
  }
}
