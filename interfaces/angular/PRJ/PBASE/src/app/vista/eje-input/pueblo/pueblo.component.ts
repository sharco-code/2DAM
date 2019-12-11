import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'pueblo',
  templateUrl: './pueblo.component.html',
  styleUrls: ['./pueblo.component.css']
})
export class PuebloComponent implements OnInit {

  @Input() pais:string;
  @Input("provincia") otroNombre:string;
  @Output() enviarPueblo = new EventEmitter();

  public pueblo = "Alberique";

  constructor() { }

  ngOnInit() {
  }

  buttonClick($event) {
    this.enviarPueblo.emit({nomPoble:this.pueblo});
  }

}
