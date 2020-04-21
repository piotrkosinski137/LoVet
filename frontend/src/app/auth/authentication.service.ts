import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegisterRequest} from "../modules/base/register/register.request";

@Injectable({providedIn: 'root'})
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  login(email: string, password: string) {
    return this.http.post<any>('/api/auth/login', {email: email, password: password});
  }

  register(registerRequest: RegisterRequest) {
    return this.http.post<any>('/api/auth/register/pet-owner', registerRequest);
  }

  getLoggedInUser() {
    return this.http.get<any>('/api/current');
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
