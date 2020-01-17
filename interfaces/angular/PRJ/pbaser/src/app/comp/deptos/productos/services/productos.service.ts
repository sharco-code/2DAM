import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Iproductos } from 'src/app/models/iproductos';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  private productUrl = 'assets/products/products.json';

  constructor(private http:HttpClient) { }

  getProductos():Observable<Iproductos[]>{
    return this.http.get<Iproductos[]>(this.productUrl);
  }

  getProducto(id:number):Observable<Iproductos | undefined>{
    return this.getProductos().pipe(map( (productos:Iproductos[]) => productos.find(p=>p.productId==id) ))
  }

}
