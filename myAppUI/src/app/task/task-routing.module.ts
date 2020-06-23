import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from "../auth/auth.guard";

export const routes: Routes = [{path:'', component:HomeComponent},
  { path: 'task', component: HomeComponent }];


export const routing: ModuleWithProviders = 
RouterModule.forChild(routes)

//export class TaskRoutingModule { }
