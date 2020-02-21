import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'home', loadChildren: () => import('./home/home.module').then( m => m.HomePageModule),
  canActivate: [AuthGuard]},  
  { path: 'config',  loadChildren: () => import('./config/config.module').then( m => m.ConfigPageModule) },   {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'pagoscaja-add',
    loadChildren: () => import('./pagoscaja/pagoscaja-add/pagoscaja-add.module').then( m => m.PagoscajaAddPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'pagoscaja-edit',
    loadChildren: () => import('./pagoscaja/pagoscaja-edit/pagoscaja-edit.module').then( m => m.PagoscajaEditPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'pagoscaja-edit/:action',
    loadChildren: () => import('./pagoscaja/pagoscaja-edit/pagoscaja-edit.module').then( m => m.PagoscajaEditPageModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'pagoscaja-list',
    loadChildren: () => import('./pagoscaja/pagoscaja-list/pagoscaja-list.module').then( m => m.PagoscajaListPageModule),
    canActivate: [AuthGuard]
  },{
    path: 'pagoscaja-list/:action',
    loadChildren: () => import('./pagoscaja/pagoscaja-list/pagoscaja-list.module').then( m => m.PagoscajaListPageModule),
    canActivate: [AuthGuard]
  },
 
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
