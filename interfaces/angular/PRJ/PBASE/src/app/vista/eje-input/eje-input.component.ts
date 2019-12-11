import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'eje-input',
  templateUrl: './eje-input.component.html',
  styleUrls: ['./eje-input.component.css']
})
export class EjeInputComponent implements OnInit {

  public pais  = "España";
  public provincia = "Valencia";

  public pueblo;

  public nombrePueblo;

  constructor() { }

  ngOnInit() {
  }

  getDatos($event) {
    this.pueblo = $event.nomPoble;
  }

}
