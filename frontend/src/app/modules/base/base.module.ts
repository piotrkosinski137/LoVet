import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BaseRoutingModule} from './base-routing.module';
import {LoginComponent} from './login/login.component';
import {NavbarComponent} from './navbar/navbar.component';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AuthInterceptor} from '../../auth/auth-interceptor.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {LayoutComponent} from './layout/layout.component';
import {MaterialModule} from '../../material.module';
import {DashboardComponent} from './dashboard/dashboard.component';
import {RegisterComponent} from "./register/register.component";


@NgModule({
  imports: [
    CommonModule,
    BaseRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  declarations: [
    LoginComponent,
    NavbarComponent,
    LayoutComponent,
    DashboardComponent,
    RegisterComponent
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  exports: [LayoutComponent]
})
export class BaseModule {
}
