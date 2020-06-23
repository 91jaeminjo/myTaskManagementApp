import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from "./auth/auth.guard";


export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  {
    path: 'signup',
    loadChildren: './auth/auth.module#AuthModule',
  },
  {
    path: 'login',
    loadChildren: './auth/auth.module#AuthModule',
  },
  {
    path: 'task',
    loadChildren: './task/task.module#TaskModule',
    canActivate: [AuthGuard]
  }
];


//export class AppRoutingModule { }
export const routing: ModuleWithProviders = 
RouterModule.forRoot(routes)
