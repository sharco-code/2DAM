import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatSortModule,
    MatTableModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatSliderModule,
    } from '@angular/material';    


const Moduls=[
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatSliderModule,
    FormsModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,  
]


@NgModule({
    declarations: [],
    imports: [Moduls],
    exports:[Moduls]

  })
  export class MatModule { }