import { Injectable } from '@angular/core';
import { Caja } from '../models/caja';

@Injectable({
  providedIn: 'root'
})
export class SharedCajaService {

  shared_caja: Caja;
  
  refresh:boolean;

  constructor() { }

  getidCaja() {
    return this.shared_caja
  }
  setidCaja(caja:Caja){
    this.shared_caja = caja;
  }
  getrefresh() {
    return this.refresh
  }
  setrefresh(refresh:boolean){
    this.refresh = refresh;
  }
}
