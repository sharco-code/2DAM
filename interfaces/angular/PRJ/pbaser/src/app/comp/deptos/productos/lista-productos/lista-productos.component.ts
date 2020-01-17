import { Component, OnInit } from '@angular/core';
import { Iproductos } from 'src/app/models/iproductos';
import { ProductosService } from '../services/productos.service';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.css']
})
export class ListaProductosComponent implements OnInit {

  Title="Lista de productos";
  ImageWith=50;
  ImageMargin=2;
  ShowImage=false;
  errorMessage="";
  _listFilter="";

  ProductosFiltrados:Iproductos[]=[];
  productos:Iproductos[]=[];

  constructor(private api:ProductosService) { }

  ngOnInit() {
    this.api.getProductos().subscribe({
      next: productos =>{
        this.productos = this.productos;
        this.ProductosFiltrados=this.productos;
      },
      error:err=>this.errorMessage=err});
    }
  toggleImage(){
    this.ShowImage=!this.ShowImage;
  }
}

