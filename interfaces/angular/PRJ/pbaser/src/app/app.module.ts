import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, CompCreados } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './cfg/login/login.component';
import { ProductosModule } from './comp/deptos/productos/productos.module';


@NgModule({
  declarations: [
    AppComponent,
    CompCreados,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProductosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
