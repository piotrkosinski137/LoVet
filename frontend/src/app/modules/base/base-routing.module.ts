import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {NgModule} from '@angular/core';
import {DashboardComponent} from './dashboard/dashboard.component';
import {DoctorModule} from "../doctor/doctor.module";
import {PetOwnerModule} from "../pet-owner/pet-owner.module";

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {
    path: 'doctor', children: [
      {
        path: '',
        loadChildren: () => DoctorModule
      }
    ]
  },
  {
    path: 'pet-owner', children: [
      {
        path: '',
        loadChildren: () => PetOwnerModule
      }
    ]
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BaseRoutingModule {
}
