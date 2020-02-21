import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import {LogM} from '../shared/log';
import { Pagoscaja } from '../models/pagoscaja';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
//const apiUrl = 'http://localhost:80/api/api.php/pagoscaja';

@Injectable({
  providedIn: 'root'
})
export class PagoscajaService {
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

  getPagoscajas(): Observable<Pagoscaja[]> {
 
    let rdo=null;
    LogM(this.API_ENDPOINT);
    if (this.urlExists(this.API_ENDPOINT + '/pagoscaja'))  {
  
        rdo=this.http.get<Pagoscaja[]>(this.API_ENDPOINT + '/pagoscaja').pipe(
            tap(pagoscaja => LogM('Obtener pagoscaja')),
            catchError(this.handleError('getPagoscajas', []))
            );    
    } 

    return rdo;
  }

  getPagoscaja(id: any): Observable<Pagoscaja> {
    //const url = `${apiUrl}/${id}`;
    return this.http.get<Pagoscaja>(this.API_ENDPOINT + '/pagoscaja/'+  id).pipe(
      tap(_ => LogM(`Obtener pagoscajao id=${id}`)),
      catchError(this.handleError<Pagoscaja>(`getPagoscaja id=${id}`))
    );
  }

  getPagoscajaByIdCaja(idCaja: number): Observable<Pagoscaja> {
    //const url = `${apiUrl}/${id}`;
    return this.http.get<Pagoscaja>(this.API_ENDPOINT + '/pagoscaja?filter=idCaja,eq,'+  idCaja).pipe(
      tap(),
      catchError(this.handleError<Pagoscaja>(`getEmpleado id=${idCaja}`))
    );
  }

  addPagoscaja(pagoscaja: Pagoscaja): Observable<Pagoscaja> {
    return this.http.post<Pagoscaja>(this.API_ENDPOINT + '/pagoscaja', pagoscaja, httpOptions).pipe(
      tap((prod: Pagoscaja) => LogM(`añadido pagoscajao w/ `)),
      catchError(this.handleError<Pagoscaja>('addPagoscaja'))
    );
  }

  updatePagoscaja(id: any, pagoscaja: any): Observable<any> {
    //const url = `${apiUrl}/${id}`;
    return this.http.put(this.API_ENDPOINT + '/pagoscaja/'+id, pagoscaja, httpOptions).pipe(
      tap(_ => LogM(`pagoscajao modificado id=${id}`)),
      catchError(this.handleError<any>('updatePagoscaja'))
    );
  }

  deletePagoscaja(id: any): Observable<Pagoscaja> {
    //const url = `${apiUrl}/${id}`;

    return this.http.delete<Pagoscaja>(this.API_ENDPOINT + '/pagoscaja/'+id, httpOptions).pipe(
      tap(_ => LogM(`pagoscajao eliminado id=${id}`)),
      catchError(this.handleError<Pagoscaja>('deletePagoscaja'))
    );
  }

 urlExists(url) {
   return fetch(url, {mode: "no-cors"})
      .then(res => true)
      .catch(err => false)
   } 
   
}