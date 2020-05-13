import {Component, OnInit} from '@angular/core';
import {Pet} from "../model/pet";
import {MatDialog} from "@angular/material/dialog";
import {AddPetModalComponent} from "./add-pet-modal/add-pet-modal.component";
import {PetService} from "../../../api/pet.service";

@Component({
  selector: 'app-pets-dashboard',
  templateUrl: './pets-dashboard.component.html',
  styleUrls: ['./pets-dashboard.component.scss']
})
export class PetsDashboardComponent implements OnInit {

  pets: Pet[] = [];

  constructor(private dialog: MatDialog, private petService: PetService) {
  }

  ngOnInit() {
    this.loadPets();
  }

  loadPets() {
    this.petService.loadFromLoggedIn().subscribe(result => this.pets = result);
  }

  onAddPetClick() {
    const dialogRef = this.dialog.open(AddPetModalComponent, {});

    dialogRef.afterClosed().subscribe(result => {
      if (result.isSubmitted) {
        this.petService.save(result.pet).subscribe(() => this.loadPets());
      }
    });
  }
}
