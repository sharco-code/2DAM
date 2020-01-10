import { Injectable } from '@angular/core';
import { Ideptos } from '../models/ideptos';


@Injectable({
  providedIn: 'root'
})


export class DeptosService {
  public depts =[
    {id:"1",name:"Contabilidad",jefe:"Luis Ponce",horario:"L 10:30h", contacto:" Avisar al tel:666666666"},
    {id:"2",name:"Nominas",jefe:"Raul Gomez",horario:"L 10:30h", contacto:" Avisar al tel:666666666"},
    {id:"3",name:"Almacen",jefe:"Pepe Romero",horario:"L 8h-20:30h", contacto:" Avisar al tel:666666666"}
  ]
  


  constructor() { }
  

  //Si recibe un id devuelve ese departamento si no devuelve todo el array
  getDatos(id?:number):Ideptos[]{
    if(id){
      return this.depts.filter(function(value,index,array){
        if(parseInt(value.id)==id) return value;
      })
    }
    else return this.depts
  }
}
