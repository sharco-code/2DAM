import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, CompCreados } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './cfg/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    CompCreados,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
