import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegisterRequest} from "../modules/base/register/register.request";
import {environment} from "../../environments/environment";

@Injectable({providedIn: 'root'})
export class AuthenticationService {

  BASE_URL = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  login(email: string, password: string) {
    return this.http.post<any>(this.BASE_URL + '/auth/login', {email: email, password: password});
  }

  register(registerRequest: RegisterRequest) {
    return this.http.post<any>(this.BASE_URL + '/auth/register/pet-owner', registerRequest);
  }

  logout() {
    localStorage.removeItem('token');
  }

  getToken() {
    return localStorage.getItem('token');
  }

  isLoggedIn() {
    return localStorage.getItem('token') !== null;
  }
}
