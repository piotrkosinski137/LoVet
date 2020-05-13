import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Pet} from "../modules/pet-owner/model/pet";
import {SavePet} from "../modules/pet-owner/model/save-pet";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PetService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  save(pet: SavePet): Observable<any> {
    return this.http.post(this.BASE_URL + '/pets', pet);
  }

  loadFromLoggedIn(): Observable<Pet[]> {
    return this.http.get<Pet[]>(this.BASE_URL + '/pets/overview/current');
  }
}
