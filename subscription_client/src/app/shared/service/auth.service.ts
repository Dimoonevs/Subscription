import { Injectable } from '@angular/core';
import { AuthResp, Couach, CouachReq } from '../interfase/interface';
import { HttpClient } from '@angular/common/http';
import { ServiceService } from '../service.service';
import { Observable, tap } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private token = null;

  constructor(private http: HttpClient, private services: ServiceService, private router: Router, private route: ActivatedRoute) { }

  login(user: Couach):Observable<AuthResp>{
    return this.http.post<AuthResp>(this.services.getAllLinks() + "coaching/login", user)
    .pipe(
      tap(
        (authResp: AuthResp) =>{
          localStorage.setItem("token", authResp.data)
          this.setToken(authResp.data)
        }
      )
    )
  }

  setToken(token: string | any){
    this.token = token;
  }

  getToken():string | any{
    return this.token;
  }

  isAuthenticated():boolean{
    return !!this.token
  }

  logout(){
    this.setToken(null);
    localStorage.clear()
  }
}
