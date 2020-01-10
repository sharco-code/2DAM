import { Injectable } from '@angular/core';
import {Iempleados} from '../models/iempleados';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {
  

  public Empleados =[
    {"id":  1, "name": "Leanne Graham", "username": "Bret", 		"email": "Sincere@april.biz",	"depto":"1"},
    {"id":  2, "name": "Ervin Howell",	"username": "Antonette","email": "Shanna@melissa.tv",	"depto":"1"},
    {"id":  3, "name": "Luis Graham", 	"username": "Luis", 		"email": "Luis@april.biz",	"depto":"2"},
    {"id":  4, "name": "Pepe Gotera", 	"username": "Pepe", 		"email": "Luis@april.biz",	"depto":"3"},  
    {"id":  5, "name": "Otilio Gilito",	"username": "Otilio",		"email": "Luis@april.biz",	"depto":"3"},  
  ]

  

  constructor() { }

  getDatos(id?:number):Iempleados[]{
    if(id){
      return this.Empleados.filter(function(value,index,array){
        if(parseInt(value.depto)==id) return value;
      })
    }
    else return this.Empleados;
  }
}
