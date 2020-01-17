import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../../home/home.component';
import { ListaProductosComponent } from './lista-productos/lista-productos.component';
import { AuthGuard } from 'src/app/guards/auth.guard';
import { PageNotFoundComponent } from '../../page-not-found/page-not-found.component';


const routes: Routes = [
  {path:'',component:ListaProductosComponent, canActivate:[AuthGuard]},
  {path:'*',component:PageNotFoundComponent, canActivate:[AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductosRoutingModule { }

export const CompDeProductos = [ListaProductosComponent]