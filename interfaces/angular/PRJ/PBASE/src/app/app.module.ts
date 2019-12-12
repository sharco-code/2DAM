import { NgModule, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HighlightDirective } from './directivas/highlight.directive';
import { EjeInputComponent } from './vista/eje-input/eje-input.component';
import { PuebloComponent } from './vista/eje-input/pueblo/pueblo.component';
import { MyCurrencyPipe } from './shared/my-currency.pipe';

@NgModule({
  imports:      [ BrowserModule, FormsModule ],
  declarations: [ AppComponent, HighlightDirective, EjeInputComponent, PuebloComponent, MyCurrencyPipe ],
  
  providers: [{provide:LOCALE_ID, useValue:'es'}],
  bootstrap:    [ AppComponent ]
  
})
export class AppModule { }
