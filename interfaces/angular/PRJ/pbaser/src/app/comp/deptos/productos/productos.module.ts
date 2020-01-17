import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductosRoutingModule, CompDeProductos } from './productos-routing.module';
import { HomeComponent } from '../../home/home.component';
import { SharedModule } from './shared/shared.module';
import { StarComponent } from './star/star.component';
import { EditProductoComponent } from './edit-producto/edit-producto.component';


@NgModule({
  declarations: [CompDeProductos, StarComponent, EditProductoComponent],
  imports: [
    CommonModule,
    ProductosRoutingModule,
    SharedModule
  ]
})
export class ProductosModule { }

