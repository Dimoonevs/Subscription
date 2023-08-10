import { Component, OnInit } from '@angular/core';
import { AuthService } from './shared/service/auth.service';

@Component({
  selector: 'app-root',
  template: '<router-outlet></router-outlet>'
})
export class AppComponent implements OnInit{
  title = 'subscription_client';

  constructor(private authService: AuthService){}
  ngOnInit(): void {
    const potentialToken = localStorage.getItem("token")
    if (potentialToken !== null){
      this.authService.setToken(potentialToken);
    }
  }
}
