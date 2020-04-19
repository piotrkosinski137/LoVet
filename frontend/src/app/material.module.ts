import {NgModule} from '@angular/core';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatDialogModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatProgressSpinnerModule,
  MatSelectModule,
  MatToolbarModule,
  MatMenuModule
} from '@angular/material';
import {FlexLayoutModule, FlexModule} from '@angular/flex-layout';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";

@NgModule({
  declarations: [],
  imports: [MatToolbarModule, FlexModule, FlexLayoutModule, MatInputModule, MatListModule, MatIconModule, MatSelectModule,
    MatProgressSpinnerModule, MatFormFieldModule, MatButtonModule, MatCardModule, MatGridListModule, MatDialogModule,
    MatAutocompleteModule, MatTableModule, MatSortModule, MatCheckboxModule, MatDatepickerModule, MatMenuModule, MatNativeDateModule],
  exports: [MatToolbarModule, FlexModule, FlexLayoutModule, MatProgressSpinnerModule, MatIconModule, MatDialogModule,
    MatFormFieldModule, MatButtonModule, MatInputModule, MatCardModule, MatGridListModule, MatListModule, MatSelectModule,
    MatAutocompleteModule, MatTableModule, MatSortModule, MatCheckboxModule, MatDatepickerModule, MatMenuModule, MatNativeDateModule]
})
export class MaterialModule {
}
