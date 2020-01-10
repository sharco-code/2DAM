import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { HomeComponent } from './comp/home/home.component';
import { AboutComponent } from './comp/about/about.component';
import { PageNotFoundComponent } from './comp/page-not-found/page-not-found.component';
import { DeptosComponent } from './comp/deptos/deptos.component';
import { EmpleadosComponent } from './comp/empleados/empleados.component';
import { ContactoComponent } from './comp/deptos/contacto/contacto.component';

import { LoginComponent } from './cfg/login/login.component';


const routes: Routes = [
  {path:'',redirectTo:'Login', pathMatch:'full'},
  {path:"Login",component:LoginComponent},
  {path:"Home",component:HomeComponent},
  {path:"Home/About",component:AboutComponent},
  {path:"Home/Deptos",
    component:DeptosComponent,
    children:[
      {path:"Home/Deptos/Contacto/:idDepto",component:ContactoComponent},
      {path:"Home/Deptos/Empleados/:idDepto/:nombreDepto",component:EmpleadosComponent}
    ]  
  },
  
  {path:"**",component:PageNotFoundComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const CompCreados = [HomeComponent,AboutComponent,PageNotFoundComponent,DeptosComponent,EmpleadosComponent,ContactoComponent,LoginComponent]
