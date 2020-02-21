import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import {LogM} from '../shared/log';
import { Caja } from '../models/caja';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
//const apiUrl = 'http://localhost:80/api/api.php/caja';

@Injectable({
  providedIn: 'root'
})
export class CajaService {
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

  getCajas(): Observable<Caja[]> {
 
    let rdo=null;
    LogM(this.API_ENDPOINT);
    if (this.urlExists(this.API_ENDPOINT + '/caja'))  {
  
        rdo=this.http.get<Caja[]>(this.API_ENDPOINT + '/caja').pipe(
            tap(caja => LogM('Obtener caja')),
            catchError(this.handleError('getCajas', []))
            );    
    } 

    return rdo;
  }

  getCaja(id: any): Observable<Caja> {
    //const url = `${apiUrl}/${id}`;
    return this.http.get<Caja>(this.API_ENDPOINT + '/caja/'+  id).pipe(
      tap(_ => LogM(`Obtener cajao id=${id}`)),
      catchError(this.handleError<Caja>(`getCaja id=${id}`))
    );
  }

  addCaja(caja: Caja): Observable<Caja> {
    return this.http.post<Caja>(this.API_ENDPOINT + '/caja', caja, httpOptions).pipe(
      tap((prod: Caja) => LogM(`añadido cajao w/ `)),
      catchError(this.handleError<Caja>('addCaja'))
    );
  }

  updateCaja(id: any, caja: any): Observable<any> {
    //const url = `${apiUrl}/${id}`;
    return this.http.put(this.API_ENDPOINT + '/caja/'+id, caja, httpOptions).pipe(
      tap(_ => LogM(`cajao modificado id=${id}`)),
      catchError(this.handleError<any>('updateCaja'))
    );
  }

  deleteCaja(id: any): Observable<Caja> {
    //const url = `${apiUrl}/${id}`;

    return this.http.delete<Caja>(this.API_ENDPOINT + '/caja/'+id, httpOptions).pipe(
      tap(_ => LogM(`cajao eliminado id=${id}`)),
      catchError(this.handleError<Caja>('deleteCaja'))
    );
  }

 urlExists(url) {
   return fetch(url, {mode: "no-cors"})
      .then(res => true)
      .catch(err => false)
   } 
   
}