import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from "./auth/auth.guard";
import { LandingComponent } from './task/landing/landing.component';


export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo:'landing' },
  { path: 'landing', component: LandingComponent },
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

export const routing: ModuleWithProviders = 
RouterModule.forRoot(routes)
