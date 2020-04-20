import {Component, OnInit} from '@angular/core';
import {Pet} from "../model/pet";
import {MatDialog} from "@angular/material/dialog";
import {AddPetModalComponent} from "./add-pet-modal/add-pet-modal.component";

@Component({
  selector: 'app-pets-dashboard',
  templateUrl: './pets-dashboard.component.html',
  styleUrls: ['./pets-dashboard.component.scss']
})
export class PetsDashboardComponent implements OnInit {

  pets: Pet[] = [
    {id: 'fd488ff8-1718-47c2-900a-67eef6606d4f', name: 'Kluszek', dateOfBirth: new Date()},
    {id: 'Dd488ff8-1718-47c2-900a-67eef6606d4f', name: 'Karotek', dateOfBirth: new Date()},
    {id: 'Vd488ff8-1718-47c2-900a-67eef6606d4f', name: 'Kefir', dateOfBirth: new Date()}
  ]

  constructor(private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  onAddPetClick() {
    const dialogRef = this.dialog.open(AddPetModalComponent, {});

    dialogRef.afterClosed().subscribe(result => {
      if (result.isSubmitted) {
        this.pets.push(result.pet)
      }
    });
  }
}
