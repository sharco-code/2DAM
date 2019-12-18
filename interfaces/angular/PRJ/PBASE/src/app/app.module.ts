import { NgModule, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './comp/home/home.component';
@NgModule({
  
  imports:      [ BrowserModule, RouterModule.forRoot([
    {path:"home", component:HomeComponent},
    {path:"About", component:AboutComponent}
   ])],
  declarations: [ AppComponent, HomeComponent, AboutComponent ],
  
  providers: [],
  bootstrap:    [ AppComponent ]
  
})
export class AppModule { }
