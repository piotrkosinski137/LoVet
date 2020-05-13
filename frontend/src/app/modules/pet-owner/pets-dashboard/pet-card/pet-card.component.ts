import {Component, Input, OnInit} from '@angular/core';
import {Pet} from "../../model/pet";
import {ActivatedRoute, Router} from "@angular/router";
import {environment} from "../../../../../environments/environment";

@Component({
  selector: 'app-pet-card',
  templateUrl: './pet-card.component.html',
  styleUrls: ['./pet-card.component.scss']
})
export class PetCardComponent implements OnInit {

  @Input()
  pet: Pet;
  BASE_URL = environment.apiUrl;

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
  }

  onPetVisitHistoryClick(id: string) {
    this.router.navigate([id + '/visits'], {relativeTo: this.activatedRoute})
  }

  preparePhotoUrl() {
    return this.pet.photoUrl ? this.BASE_URL + '/lovet-images/' + this.pet.photoUrl : 'assets/default-pet.png';
  }
}
