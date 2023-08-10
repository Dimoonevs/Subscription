import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './shared/layout/home/home.component';
import { SubscriptionComponent } from './shared/layout/subscription/subscription.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './shared/layout/admin/admin.component';
import { HeaderFooterComponent } from './shared/layout/header-footer/header-footer.component';
import { LoginComponent } from './shared/layout/login/login.component';
import { TokenInterceptor } from './shared/model/token.interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateComponent } from './shared/layout/update/update.component';
import { AddNewSportsmenComponent } from './shared/layout/add-new-sportsmen/add-new-sportsmen.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SubscriptionComponent,
    AdminComponent,
    HeaderFooterComponent,
    LoginComponent,
    UpdateComponent,
    AddNewSportsmenComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      multi: true,
      useClass: TokenInterceptor
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 
  
}
