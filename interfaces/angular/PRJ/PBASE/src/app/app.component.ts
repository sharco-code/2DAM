import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl:"app.component.html",
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  name = 'Jose';

  private stat = true;

  public id1 = "InputID1"
  public isDisabled = true;
  public type = "text";

  public myStyle = "red";

  public mycolors = {
    BGcolor1:this.stat,
    TXTcolor1:this.stat,
    TXTproperty1:this.stat
  };
}
