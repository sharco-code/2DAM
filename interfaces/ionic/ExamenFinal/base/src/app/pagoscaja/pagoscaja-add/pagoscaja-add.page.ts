import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { NewPagoscaja, Pagoscaja } from 'src/app/models/pagoscaja';
import { PagoscajaService } from 'src/app/servicios/pagoscaja.service';
import { SharedCajaService } from 'src/app/shared/shared-caja.service';
import { NavController, AlertController, ToastController } from '@ionic/angular';
import { PagoscajaListPage } from '../pagoscaja-list/pagoscaja-list.page';

@Component({
  selector: 'app-pagoscaja-add',
  templateUrl: './pagoscaja-add.page.html',
  styleUrls: ['./pagoscaja-add.page.scss'],
})
export class PagoscajaAddPage implements OnInit {

  public currentUser;
  public idEmpleado;

  public impo="";
  public desc="";
  public hora;
  public come="";

  public pagoscaja: NewPagoscaja = new NewPagoscaja(0,this.sharedCaja.getidCaja().idCaja,+this.impo,this.desc,this.hora,this.idEmpleado,this.come);
  

  constructor(public router:Router,
    public api: PagoscajaService,
    public sharedCaja: SharedCajaService,
    public navCtrl: NavController, public alertCtrl: AlertController,
    private toastCtrl: ToastController) { 
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.idEmpleado = this.currentUser.idEmpleado;
  }

  ngOnInit() {
  }
  Back() {
    this.router.navigate(['/pagoscaja-list','R']);
  }
  editing: boolean;
  isLoadingResults = false;
  @Output() Event = new EventEmitter<any>();
  async Add() {
    
    this.pagoscaja.idEmpleado=this.idEmpleado;
    this.pagoscaja.Comentario=this.come;
    this.pagoscaja.Descripcion=this.desc;
    this.pagoscaja.Hora=this.hora;
    this.pagoscaja.Importe=+this.impo;
    this.pagoscaja.idCaja = this.sharedCaja.getidCaja().idCaja;

    this.isLoadingResults = true;
      this.api.addPagoscaja(this.pagoscaja).subscribe((data) => {
        this.isLoadingResults = false;
        this.router.navigate(['/pagoscaja-list','R']);
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
