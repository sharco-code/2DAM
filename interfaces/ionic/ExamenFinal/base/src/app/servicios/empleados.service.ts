import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { catchError, tap, map } from 'rxjs/operators';
import { Empleados } from '../models/empleados';
import { Router } from '@angular/router';
import { LogM } from '../shared/log';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class EmpleadosService {
  public API_ENDPOINT;
  public Config;

  constructor(private http: HttpClient,public router: Router) { 
    LogM(this.API_ENDPOINT);
    
    this.Config=JSON.parse(localStorage.getItem('ConfigTest'));
    if (this.Config)
        this.API_ENDPOINT = 'http://'+this.Config.IP+':80/api/api.php';
    else
        this.API_ENDPOINT = 'http://localhost:80/api/api.php'; 
        
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {    
      LogM(error);
      this.router.navigateByUrl('/config');
      return of(result as T);
    };
  }

  getEmpleados(): Observable<Empleados[]> {
 
    let rdo=null;
    LogM(this.API_ENDPOINT);
    if (this.urlExists(this.API_ENDPOINT + '/empleados'))  {
  
        rdo=this.http.get<Empleados[]>(this.API_ENDPOINT + '/empleados').pipe(
            tap(product => LogM('Obtener empleados')),
            catchError(this.handleError('getEmpleados', []))
            );    
    } 

    return rdo;
  }

  getEmpleado(user: string): Observable<Empleados> {
    //const url = `${apiUrl}/${id}`;
    return this.http.get<Empleados>(this.API_ENDPOINT + '/empleados?filter=Empleado,eq,'+  user).pipe(
      tap(),
      catchError(this.handleError<Empleados>(`getEmpleado id=${user}`))
    );
  }

  addEmpleado(product: Empleados): Observable<Empleados> {
    return this.http.post<Empleados>(this.API_ENDPOINT + '/empleados', product, httpOptions).pipe(
      tap((prod: Empleados) => LogM(`añadido empleado w/ id=${prod.idEmpleado}`)),
      catchError(this.handleError<Empleados>('addEmpleado'))
    );
  }

  updateEmpleado(id: any, product: any): Observable<any> {
    //const url = `${apiUrl}/${id}`;
    return this.http.put(this.API_ENDPOINT + '/empleados/'+id, product, httpOptions).pipe(
      tap(_ => LogM(`empleado modificado id=${id}`)),
      catchError(this.handleError<any>('updatePEmpleado'))
    );
  }

  deleteEmpleado(id: any): Observable<Empleados> {
    //const url = `${apiUrl}/${id}`;

    return this.http.delete<Empleados>(this.API_ENDPOINT + '/empleados/'+id, httpOptions).pipe(
      tap(_ => LogM(`empleado eliminado id=${id}`)),
      catchError(this.handleError<Empleados>('deleteEmpleado'))
    );
  }

 urlExists(url) {
   return fetch(url, {mode: "no-cors"})
      .then(res => true)
      .catch(err => false)
   } 
   
}