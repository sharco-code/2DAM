import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductosRoutingModule, CompDeProductos } from './productos-routing.module';
import { HomeComponent } from '../../home/home.component';
import { SharedModule } from './shared/shared.module';
import { StarComponent } from './star/star.component';


@NgModule({
  declarations: [CompDeProductos, StarComponent],
  imports: [
    CommonModule,
    ProductosRoutingModule,
    SharedModule
  ]
})
export class ProductosModule { }

