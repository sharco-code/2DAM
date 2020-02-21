import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PagoscajaListPageRoutingModule } from './pagoscaja-list-routing.module';

import { PagoscajaListPage } from './pagoscaja-list.page';
import { MatModule } from '../mat.module';
import { MaterialModule } from 'src/app/material.module';
import { PagoscajaFilterComponent } from '../pagoscaja-filter/pagoscaja-filter.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CommonModule,
    PagoscajaListPageRoutingModule,
    MatModule,
    MaterialModule,
  ],
  declarations: [PagoscajaListPage, PagoscajaFilterComponent]
})
export class PagoscajaListPageModule {}
