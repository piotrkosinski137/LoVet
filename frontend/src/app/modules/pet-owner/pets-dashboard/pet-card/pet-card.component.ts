import {Component, Input, OnInit} from '@angular/core';
import {Pet} from "../../model/pet";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-pet-card',
  templateUrl: './pet-card.component.html',
  styleUrls: ['./pet-card.component.scss']
})
export class PetCardComponent implements OnInit {

  @Input()
  pet: Pet;

  imageUrl: string | ArrayBuffer = "https://bulma.io/images/placeholders/128x128.png";

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.getPhotoUrl()
  }

  getPhotoUrl() {
    if (this.pet.imageFile) {
      const reader = new FileReader();
      reader.readAsDataURL(this.pet.imageFile);

      reader.onload = event => {
        this.imageUrl = reader.result;
      };
    }
  }

  onPetVisitHistoryClick(id: string) {
    this.router.navigate([id + '/visits'], {relativeTo: this.activatedRoute})
  }
}
