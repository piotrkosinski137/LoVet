import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {WorkingHoursManagerComponent} from "./working-hours/working-hours-manager/working-hours-manager.component";

const routes: Routes = [
  {path: '', redirectTo: 'working-hours', pathMatch: 'full'},
  {path: 'working-hours', component: WorkingHoursManagerComponent}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DoctorRoutingModule {
}
