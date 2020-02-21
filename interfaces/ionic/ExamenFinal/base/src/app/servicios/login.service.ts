import { Injectable } from '@angular/core';
import { EmpleadosToAJSON } from '../models/empleados';
import { EmpleadosService } from '../servicios/empleados.service';
import { Router } from '@angular/router';
import { StoragesessionService } from './storagesession.service';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  Empleado:any;
  constructor(
    public api: EmpleadosService,
    private router: Router,
    private storeSessionService: StoragesessionService
  ) {}
    
    login(username:string, password:string) {

      this.storeSessionService.setSessionloggedOut();
      this.api.getEmpleado(username).subscribe(res => {
        this.Empleado = EmpleadosToAJSON(res);
        if(this.Empleado.length>0) {
          if(password == this.Empleado[0].Clave) {
            let token = "aaaaa";
            let u = {idEmpleado:this.Empleado[0].idEmpleado,username: username, token:token};
            this.storeSessionService.setSessionloggedIn(u);
            this.router.navigateByUrl('/home');
          }
        }
      }, err => {
      });
    }

    logout() {
      this.storeSessionService.setSessionloggedOut();
    }
  
}