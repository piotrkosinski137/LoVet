import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Pet} from "../modules/pet-owner/model/pet";
import {SavePet} from "../modules/pet-owner/model/save-pet";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PetService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  save(pet: SavePet) {
    this.http.post(this.BASE_URL + '/pets', pet).subscribe();
  }

  loadFromLoggedIn() {
    this.http.get(this.BASE_URL + '/pets/overview/current').subscribe(result => console.log(result))
  }
}
