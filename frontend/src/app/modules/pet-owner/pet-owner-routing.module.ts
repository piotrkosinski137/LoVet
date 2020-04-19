import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookVisitComponent} from "./book-visit/book-visit.component";
import {VisitsDashboardComponent} from "./visits-dashboard/visits-dashboard.component";

const routes: Routes = [
  {path: '', redirectTo: 'book-visit', pathMatch: 'full'},
  {path: 'book-visit', component: BookVisitComponent},
  {path: 'visits', component: VisitsDashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PetOwnerRoutingModule {
}
