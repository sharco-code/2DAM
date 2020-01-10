import { Component, OnInit } from '@angular/core';
import { Isession } from 'src/app/models/isession';
import { StoragesessionService } from 'src/app/servicios/storagesession.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public logged:Isession;

  constructor(private SessionService:StoragesessionService) {
    this.logged = this.SessionService.SessionLogged;
   }

  ngOnInit() {
  }

}
