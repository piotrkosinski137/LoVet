import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PetOwnerService {

  constructor(private http: HttpClient) { }


  getLoggedInPetOwner() {
    this.http.get('/api/pet-owner/current').subscribe()
  }
}
