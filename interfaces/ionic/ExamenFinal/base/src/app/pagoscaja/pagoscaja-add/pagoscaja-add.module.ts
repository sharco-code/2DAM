import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule, IonIcon } from '@ionic/angular';

import { PagoscajaAddPageRoutingModule } from './pagoscaja-add-routing.module';

import { PagoscajaAddPage } from './pagoscaja-add.page';
import { MatModule } from '../mat.module';
import { MaterialModule } from 'src/app/material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MaterialModule,
    MatModule,
    PagoscajaAddPageRoutingModule
  ],
  declarations: [PagoscajaAddPage]
})
export class PagoscajaAddPageModule {}
