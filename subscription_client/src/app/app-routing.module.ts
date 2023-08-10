import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './shared/layout/home/home.component';
import { SubscriptionComponent } from './shared/layout/subscription/subscription.component';
import { HeaderFooterComponent } from './shared/layout/header-footer/header-footer.component';
import { AdminComponent } from './shared/layout/admin/admin.component';
import { LoginComponent } from './shared/layout/login/login.component';
import { AuthGuard } from './shared/classes/auth.guard';
import { UpdateComponent } from './shared/layout/update/update.component';
import { AddNewSportsmenComponent } from './shared/layout/add-new-sportsmen/add-new-sportsmen.component';

const routes: Routes = [
  {path:'', component: HeaderFooterComponent, children:
    [
      {path:'', component: HomeComponent},
      {path: 'subscribtion', component: SubscriptionComponent},
      {path: 'login', component: LoginComponent}
    ]
  },
  {path: '08d3n7i26a377m81', component:AdminComponent, canActivate: [AuthGuard]},
  {path: 'update/:id', component:UpdateComponent, canActivate:[AuthGuard]},
  {path: 'add', component:AddNewSportsmenComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
