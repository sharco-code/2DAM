import { Component, OnInit } from '@angular/core';
import { DeptosService } from '../../servicios/deptos.service'
import { Ideptos } from 'src/app/models/ideptos';
import { ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-deptos',
  templateUrl: './deptos.component.html',
  styles: []
})
export class DeptosComponent implements OnInit {
  public departamentos:Ideptos[];
  public DeptoSelectedId;
  constructor( private RutaActiva:ActivatedRoute,private dataapi:DeptosService ) {
    this.departamentos = this.dataapi.getDatos(this.DeptoSelectedId)
   }

  ngOnInit() {
    this.RutaActiva.paramMap.subscribe((params:ParamMap)=>{
      this.DeptoSelectedId=params.get("id");
    })
  }

}
