import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable, catchError, throwError } from "rxjs"
import { AuthService } from "../service/auth.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor{
    constructor(private router: Router, private authService: AuthService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if ( this.authService.isAuthenticated()) {
            req = req.clone({
                setHeaders: {
                    Authorization: "Bearer "+ this.authService.getToken()
                }
            })
        }
        return next.handle(req).pipe(
            catchError(
                (error:HttpErrorResponse) => this.handleAuthError(error)
            )
        )
    }

    private handleAuthError(error: HttpErrorResponse): Observable<any>{
        if (error.status === 403){
            this.router.navigate(['/login'], {
                queryParams: {
                    sassionFailed: true
                }
            })
            this.authService.logout()
        }
        if(error.status === 500){
            this.router.navigate(['/login'], {
                queryParams: {
                    sassionFailed: true
                }
            })
            this.authService.logout()
        }
        return throwError(error);
    
    }
}