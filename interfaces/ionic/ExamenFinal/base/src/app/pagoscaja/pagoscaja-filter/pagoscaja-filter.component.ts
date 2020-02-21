import { Component, OnInit, ViewChild,  Output, EventEmitter  } from '@angular/core';
import { Caja, CajaToAJSON, NewCaja } from 'src/app/models/caja';
import { Subscription } from 'rxjs';
import { CajaService } from 'src/app/servicios/caja.service';
import { LoadingController, Platform, NavController, AlertController } from '@ionic/angular';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { LogM } from 'src/app/shared/log';
import { isNumber } from 'util';
import { SharedCajaService } from 'src/app/shared/shared-caja.service';

@Component({
  selector: 'app-pagoscaja-filter',
  templateUrl: './pagoscaja-filter.component.html',
  styleUrls: ['./pagoscaja-filter.component.scss'],
})

export class PagoscajaFilterComponent implements OnInit {
  @ViewChild("select",{static: false}) selection: string;

  cajas: Caja[];

  private myCon:Subscription;
  private loading;
  private Action="N"; 

  
  constructor(public api: CajaService,
    public loadingController: LoadingController,
    public router: Router,
    public RutaActiva: ActivatedRoute,
    public platform: Platform,
    public navCtrl: NavController, public alertCtrl: AlertController,
    public sharedCaja:SharedCajaService
    ) {    
      
      this.Action = this.RutaActiva.snapshot.paramMap.get('action'); 
      LogM("Construct:"+this.Action); }

      RefreshNewEdit() {    
        //try { 
          this.myCon.unsubscribe(); 
        /*} catch(e) {
          console.log(e); 
        }*/
          this.getCajas();          
          this.Action="N"; 
  } 
  ionViewWillEnter() {
    if (this.Action=="R") this.RefreshNewEdit();
  }
  

  ngOnInit() {
    this.RutaActiva.params.subscribe((parametro:ParamMap)=>{
      this.Action=this.RutaActiva.snapshot.paramMap.get('action'); 
    });
    this.getCajas();
    
  }

  async getCajas() {
    /* */
     this.loading = await this.loadingController.create({
          message: 'Loading...'
     });
     await this.loading.present();   
     await this.subscripcion();       
     
    // this.subscripcion();       
  }

  subscripcion(){
    this.myCon=this.api.getCajas().subscribe(res => {
      this.cajas = CajaToAJSON(res);
      LogM(this.cajas);      
    }, err => {
      LogM(err);     
    });
    this.loading.dismiss(); 
  }  

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.cajas, event.previousIndex, event.currentIndex);
  }

  public importeinicial: number = 0;

  public isEnabled:boolean = true;

  @Output() Event = new EventEmitter<number>();

  public value: number;
  c:NewCaja = new NewCaja(0, "", 0);

  FechaSeleccionada(selectedValue) {
    if(selectedValue==undefined) {

      return;
    }
    this.value = selectedValue;
    //console.log("Fecha seleccionada:"+this.cajas[selectedValue].Fecha);
    this.importeinicial = this.cajas[selectedValue].DineroCambio;
    this.isEnabled = false;

    this.Event.next(this.cajas[selectedValue].idCaja);
    
    this.c.idCaja = this.cajas[selectedValue].idCaja;
    this.c.Fecha = this.cajas[selectedValue].Fecha;

    this.sharedCaja.setidCaja(this.cajas[selectedValue]);
  }
  

  async EditAperturacaja(){
    let prompt = await this.alertCtrl.create({
      message: "Introduce un nuevo importe inicial",
      inputs: [
        {
          name: 'importe',
          type: 'number',
          placeholder: 'Importe Inicial',
        }
      ],
      buttons: [
        {
          text: 'Cancelar',
          handler: data => {
          }
        },
        {
          text: 'Guardar',
          handler: async data => {
            //este if compreuba si es numero o no
            if(!isNaN(+data.importe)) {
              this.c.DineroCambio = +data.importe;

              this.api.updateCaja(this.cajas[this.value].idCaja, this.c).subscribe(async (data) => {
                this.getCajas();
               // console.log(this.importeinicial);
              }, (error) => {
                LogM("error edit:" + error);
              });
              this.importeinicial = +data.importe;
            } else {
              const alert = await this.alertCtrl.create({
                header:"Error",
                message:"Tiene que ser un valor numerico",
                buttons:['Aceptar']
              });
              await alert.present();
            }


          }
        }
      ]
    });
    prompt.present();
  }
  
}

