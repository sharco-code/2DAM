import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute, ParamMap } from '@angular/router';
import { EmpleadosService } from 'src/app/servicios/empleados.service';
import { Iempleados } from 'src/app/models/iempleados';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styles: []
})
export class EmpleadosComponent implements OnInit {

  public EmpleadoDepto:Iempleados[];


  public Departamento:{id:string,Nombre:string};

  constructor(
    private router:Router,
    private RutaActiva:ActivatedRoute,
    private EmpleadosService:EmpleadosService) { }

  ngOnInit() {
    this.RutaActiva.paramMap.subscribe((Parametros:ParamMap)=> 
      this.Departamento= {
        id:this.RutaActiva.snapshot.paramMap.get('idDepto'),
        Nombre:Parametros.get('nombreDepto')
    })

    this.EmpleadoDepto = this.EmpleadosService.getDatos(parseInt(this.Departamento.id));

    
  }
  IrEmplNoExiste(){
    this.router.navigate(['/Empleados','25','Ventas'])

  }

  onClick(){
    this.router.navigate(["Home/Deptos"]);
  }
}
