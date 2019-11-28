import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl:"app.component.html",
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  coche = '';


  private stat = true;

  public id1 = "InputID1"
  public isDisabled = false;
  public type = "text";

  public myStyle = "red";

  public padding = "4%";

  public mycolors = {
    BGcolor1:this.stat,
    TXTcolor1:this.stat,
    TXTproperty1:this.stat
  };

  public contador = 0;
  public texto = "";

  public click(){
    this.contador += 10;
  }
  public initalD() {
    this.contador = 20;
    console.log("Se ha cargado el valor"+ this.contador);
  }

  public onClick(value) {
    this.contador++;
    this.texto = "hola";
  }

  //-----------------

  poli = {
    name:"Scooby doo papa",
    date:"16/16/1923"
  }

  CambiaCoche(event) {
    this.coche = event.value;
    console.log("CambiaCoche(event)");
  }
}