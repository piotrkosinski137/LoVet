import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<any>('/api/auth', {username: username, password: password});
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
