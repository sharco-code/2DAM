import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PagoscajaAddPage } from './pagoscaja-add.page';

const routes: Routes = [
  {
    path: '',
    component: PagoscajaAddPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagoscajaAddPageRoutingModule {}
