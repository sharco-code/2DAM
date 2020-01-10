import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { DeptosService } from 'src/app/servicios/deptos.service';
import { Ideptos } from 'src/app/models/ideptos';
import { Location } from '@angular/common'

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styles: []
})
export class ContactoComponent implements OnInit {

  public Departamento:Ideptos[];
  public DeptoSelectedId;


  constructor(
    private router:Router,
    private RutaActiva:ActivatedRoute,
    private DeptoService:DeptosService,
    private location:Location) {
      this.Departamento = this.DeptoService.getDatos(this.DeptoSelectedId);
     }

  ngOnInit() {
    this.RutaActiva.paramMap.subscribe((Parametros:ParamMap)=> 
    {
      this.DeptoSelectedId= Parametros.get("idDepto");
      this.Departamento = this.DeptoService.getDatos(parseInt(this.DeptoSelectedId))

    })
  }

  onClick(){
    //this.router.navigate(["Empleados",this.DeptoSelectedId,this.Departamento[0].name])
    this.location.back();
  }
      

}
