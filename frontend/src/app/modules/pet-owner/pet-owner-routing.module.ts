import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookVisitComponent} from "./book-visit/book-visit.component";
import {VisitsDashboardComponent} from "./visits-dashboard/visits-dashboard.component";
import {PetsDashboardComponent} from "./pets-dashboard/pets-dashboard.component";
import {PetVisitHistoryComponent} from "./pets-dashboard/pet-visit-history/pet-visit-history.component";

const routes: Routes = [
  {path: '', redirectTo: 'book-visit', pathMatch: 'full'},
  {path: 'book-visit', component: BookVisitComponent},
  {path: 'visits', component: VisitsDashboardComponent},
  {path: 'pets', component: PetsDashboardComponent},
  {path: 'pets/:id/visits', component: PetVisitHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PetOwnerRoutingModule {
}
