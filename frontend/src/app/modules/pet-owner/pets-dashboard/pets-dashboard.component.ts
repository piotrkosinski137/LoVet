import { Component, OnInit } from '@angular/core';
import {Pet} from "../model/pet";

@Component({
  selector: 'app-pets-dashboard',
  templateUrl: './pets-dashboard.component.html',
  styleUrls: ['./pets-dashboard.component.scss']
})
export class PetsDashboardComponent implements OnInit {

  pets: Pet[] = [
    {name: 'Kluszek'},
    {name: 'Karotek'},
    {name: 'Kefir'},
    {name: 'Buraczek'}
  ]

  constructor() { }

  ngOnInit() {
  }

}
