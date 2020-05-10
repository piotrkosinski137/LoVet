import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PetOwnerService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getLoggedInPetOwner() {
    this.http.get(this.BASE_URL + '/pet-owner/overview/current').subscribe()
  }
}
