import {Component, Input, OnInit} from '@angular/core';
import {Pet} from "../../model/pet";

@Component({
  selector: 'app-pet-card',
  templateUrl: './pet-card.component.html',
  styleUrls: ['./pet-card.component.scss']
})
export class PetCardComponent implements OnInit {

  @Input()
  pet: Pet;

  constructor() { }

  ngOnInit() {
  }

}
