import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PagoscajaListPage } from './pagoscaja-list.page';

const routes: Routes = [
  {
    path: '',
    component: PagoscajaListPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagoscajaListPageRoutingModule {}
