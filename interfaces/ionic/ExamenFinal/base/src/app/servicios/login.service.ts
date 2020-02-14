import { Injectable } from '@angular/core';
import { EmpleadosToAJSON } from '../models/empleados';
import { EmpleadosService } from '../servicios/empleados.service';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  Empleado:any;

  constructor(
    public api: EmpleadosService
  ) { }
    rdo=false;
    login(username:string, password:string) {
      this.api.getEmpleado(username).subscribe(res => {
        
        this.Empleado = EmpleadosToAJSON(res);
        this.rdo = password!=this.Empleado[0].Clave;
        return this.rdo;
      });
      return this.rdo;
    }
  
}