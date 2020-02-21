import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PagoscajaEditPageRoutingModule } from './pagoscaja-edit-routing.module';

import { PagoscajaEditPage } from './pagoscaja-edit.page';
import { MaterialModule } from 'src/app/material.module';
import { MatModule } from '../mat.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MaterialModule,
    MatModule,
    PagoscajaEditPageRoutingModule
  ],
  declarations: [PagoscajaEditPage]
})
export class PagoscajaEditPageModule {}
