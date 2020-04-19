import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {BookVisitComponent} from "./book-visit/book-visit.component";

const routes: Routes = [
  {path: '', redirectTo: 'visit', pathMatch: 'full'},
  {path: 'visit', component: BookVisitComponent}
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PetOwnerRoutingModule {
}
