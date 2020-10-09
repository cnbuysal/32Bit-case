import { ListKardemirComponent } from './kardemir/list-kardemir/list-kardemir.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateKardemirComponent } from './kardemir/create-kardemir/create-kardemir.component';

const routes: Routes = [
  { path: 'create-kardemir', component: CreateKardemirComponent },
  { path: '', component: ListKardemirComponent },
  { path: 'sign-up', component: SignupComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
