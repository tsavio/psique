import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {


  constructor(private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
    return this.checkLogin();
  }

  checkLogin(): boolean {
    if (sessionStorage.getItem('user')) { return true; }

    this.router.navigate(['/auth/login']);
    return false;
  }

}