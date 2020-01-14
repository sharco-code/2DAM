import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductosRoutingModule, CompDeProductos } from './productos-routing.module';
import { HomeComponent } from '../../home/home.component';


@NgModule({
  declarations: [CompDeProductos],
  imports: [
    CommonModule,
    ProductosRoutingModule
  ]
})
export class ProductosModule { }

