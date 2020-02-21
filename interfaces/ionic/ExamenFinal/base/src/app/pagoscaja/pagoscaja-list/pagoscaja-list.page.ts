import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { PagoscajaService } from 'src/app/servicios/pagoscaja.service';
import { LoadingController, Platform, AlertController, NavController, ToastController } from '@ionic/angular';
import { Subscription } from 'rxjs';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { PagoscajaToAJSON, Pagoscaja } from 'src/app/models/pagoscaja';
import { LogM } from 'src/app/shared/log';
import { SharedCajaService } from 'src/app/shared/shared-caja.service';

@Component({
  selector: 'app-pagoscaja-list',
  templateUrl: './pagoscaja-list.page.html',
  styleUrls: ['./pagoscaja-list.page.scss'],
})
export class PagoscajaListPage implements OnInit {
  
  pagoscajas: Pagoscaja[];

  private myCon: Subscription;
  private loading;
  private Action = "N";

  public currentUser;
  public user;

  //isenabled
  public nuevo:boolean = true;

  public idCaja:number;

  constructor(public api: PagoscajaService,
    public loadingController: LoadingController,
    public router: Router,
    public RutaActiva: ActivatedRoute,
    public platform: Platform,
    public navCtrl: NavController, public alertCtrl: AlertController,
    private toastCtrl: ToastController,
    private sharedCaja: SharedCajaService
  ) {
    this.Action = this.RutaActiva.snapshot.paramMap.get('action');
    LogM("Construct:" + this.Action);

    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.user = this.currentUser.username;
  }

  Reload(idCaja:number) {
    this.idCaja = idCaja;
    this.getPagoscajas();
    this.nuevo = false;
  }
  ReloadBack(x:any) {
    this.getPagoscajas();
    this.nuevo = false;
  }

  Back() {
    this.router.navigateByUrl("/home");
  }

  async RemovePagocaja(pagoscaja:Pagoscaja){
    let prompt = await this.alertCtrl.create({
      message: "¿Estas seguro de que quieres borrar este registro?",
      buttons: [
        {
          text: 'Cancelar',
          handler: data => {
            
          }
        },
        {
          text: 'Borrar',
          handler: async data => {
            prompt.present();

              this.api.deletePagoscaja(pagoscaja.idPagoCaja).subscribe(async (data) => {
              this.Reload(this.idCaja);

              let toast = await this.toastCtrl.create({
                message: 'Registro borrado ',
                duration: 1500,
                position: 'bottom'
              });
            
            
              toast.present();
            });
          }
        }
      ]
    });
    prompt.present();
  }

  EditPagocaja(pagoscaja:Pagoscaja) {
    this.router.navigate(['/pagoscaja-edit',pagoscaja.idPagoCaja]);
  }
  async AddPagocaja() {
    if(this.idCaja!=undefined) {
      this.router.navigateByUrl("/pagoscaja-add");
    } else {
      const alert = await this.alertCtrl.create({
        message:"Tienes que seleccionar un dia para poder añadir un registro",
        buttons:['Aceptar']
      });
      await alert.present();
    }
    
  }
  RefreshNewEdit() {
    this.idCaja=this.sharedCaja.shared_caja.idCaja;
    this.Reload(this.idCaja);
    this.Action = "N";
  }
  ionViewWillEnter() {
    if(this.Action=="R") {
      this.RefreshNewEdit();
    }
  }

  ngOnInit() {
    this.RutaActiva.params.subscribe((parametro: ParamMap) => {
      this.Action = this.RutaActiva.snapshot.paramMap.get('action');
    });
  if(this.idCaja!=undefined||this.sharedCaja.refresh) {
    this.Reload(this.idCaja);
  }
    //this.getPagoscajas();
  }

  async getPagoscajas() {
    /* */
    this.loading = await this.loadingController.create({
      message: 'Loading...'
    });
    await this.loading.present();
    await this.subscripcion();

    // this.subscripcion();       
  }

  subscripcion() {
    this.myCon = this.api.getPagoscajaByIdCaja(this.idCaja).subscribe(res => {
      this.pagoscajas = PagoscajaToAJSON(res);
      LogM(this.pagoscajas);
    }, err => {
      LogM(err);
    });
    this.loading.dismiss();
  }
  /*
  addProduct() {
  this.router.navigate(['/product-add']);
  }
  addProduct1() {
  this.router.navigate(['/product-edit']);
  }
  */

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.pagoscajas, event.previousIndex, event.currentIndex);
  }
}
