import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {AuthenticationService} from './authentication.service';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.authenticationService.isLoggedIn()) {
      return true;
    }

    this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
    return false;
  }
}
