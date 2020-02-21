import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PagoscajaEditPage } from './pagoscaja-edit.page';

const routes: Routes = [
  {
    path: '',
    component: PagoscajaEditPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagoscajaEditPageRoutingModule {}
