import { Component } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import localeES from '@angular/common/locales/es';

@Component({
  selector: 'my-app',
  templateUrl:"app.component.html",
  styleUrls: [ './app.component.css' ]
})

export class AppComponent  {

  public depts =[
    {id:"1",name:"Contabilidad",jefe:"Luis Ponce",horario:"L 10:30h", contacto:" Avisar al tel:666666666"},
    {id:"2",name:"Nominas",jefe:"Raul Gomez",horario:"L 10:30h", contacto:" Avisar al tel:666666666"},
    {id:"3",name:"Almacen",jefe:"Pepe Romero",horario:"L 8h-20:30h", contacto:" Avisar al tel:666666666"}
  ]
}

