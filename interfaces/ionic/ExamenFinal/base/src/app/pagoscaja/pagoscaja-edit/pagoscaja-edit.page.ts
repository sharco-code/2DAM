import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PagoscajaService } from 'src/app/servicios/pagoscaja.service';
import { SharedCajaService } from 'src/app/shared/shared-caja.service';
import { AlertController, ToastController, NavController } from '@ionic/angular';
import { NewPagoscaja } from 'src/app/models/pagoscaja';
import { LogM } from 'src/app/shared/log';
import { stringify } from 'querystring';

@Component({
  selector: 'app-pagoscaja-edit',
  templateUrl: './pagoscaja-edit.page.html',
  styleUrls: ['./pagoscaja-edit.page.scss'],
})
export class PagoscajaEditPage implements OnInit {

  public currentUser;
  public idEmpleado;

  _id = '';
  public impo="";
  public desc="";
  public hora;
  public come="";

  public pagoscaja: NewPagoscaja = new NewPagoscaja(0,this.sharedCaja.getidCaja().idCaja,+this.impo,this.desc,this.hora,this.idEmpleado,this.come);
  editing: boolean;
  isLoadingResults = false;

  constructor(public router:Router,
    public api: PagoscajaService,
    public sharedCaja: SharedCajaService,
    public RutaActiva: ActivatedRoute,
    public navCtrl: NavController, public alertCtrl: AlertController,
    private toastCtrl: ToastController) { 

      this._id = this.RutaActiva.snapshot.paramMap.get('action');
    LogM("Construct:" + this._id);

    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.idEmpleado = this.currentUser.idEmpleado;
  }

  ngOnInit() {
      this.api.getPagoscaja(this._id).subscribe({
        next: p => {
        // console.log("Atenció:"+id+"->"+JSON.stringify(p));
        this.pagoscaja = p;   
        this.desc = this.pagoscaja.Descripcion;
        this.come = this.pagoscaja.Comentario;
        this.impo = this.pagoscaja.Importe.toString();
        this.hora = this.pagoscaja.Hora;
        },
    });
    this.editing=true;  
  /*
        if (this._id) {
            this.editing=true;           
            this.api.getPagoscaja(this._id).subscribe({
                next: p => {
                // console.log("Atenció:"+id+"->"+JSON.stringify(p));
                this.pagoscaja = p;         
                },
            });
            this.desc = this.pagoscaja.Descripcion;
            console.log(this.desc);
        } else{
            this.editing=false;
        }
        */
  }
  Back() {
    this.router.navigate(['/pagoscaja-list','R']);
  }
  async Add() {
    
    this.pagoscaja.idEmpleado=this.idEmpleado;
    this.pagoscaja.Comentario=this.come;
    this.pagoscaja.Descripcion=this.desc;
    this.pagoscaja.Hora=this.hora;
    this.pagoscaja.Importe=+this.impo;
    this.pagoscaja.idCaja = this.sharedCaja.getidCaja().idCaja;

    

    this.isLoadingResults = true;
        if (this.editing) {  //Edit producto existente
            this.api.updatePagoscaja(this.pagoscaja.idPagoCaja,this.pagoscaja).subscribe((data) => { 
           // const id = this.product.productId;
            this.isLoadingResults = false;
            //this.router.navigate(['/product-detail', id]);
            this.router.navigate([ '/pagoscaja-list','R']); 
            }, (error) => {
            })  
        } else{ // Nuevo producto 
                this.api.addPagoscaja(this.pagoscaja).subscribe((data) => {  
                    LogM("Nuevo:"+data);  //data es el id del producto generado !!!    
                    this.isLoadingResults = false;
                    // this.router.navigate(['/product-detail', data]); 
                    this.router.navigate([ '/product-list','R']);                                  
                }, (error) => {
                   LogM("error add:"+error);
                });
        }    

      this.api.addPagoscaja(this.pagoscaja).subscribe((data) => {
      })
      let toast = await this.toastCtrl.create({
        message: 'Registro añadido',
        duration: 1500,
        position: 'bottom'
      });
    
      toast.present();
      this.router.navigate(['/pagoscaja-list','R']);
  }

}
