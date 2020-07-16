import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
         { path: "", component: LoginComponent },
         { path: "signup", component: SignUpComponent },
         { path: "login", component: LoginComponent },
       ];
    

export const routing: ModuleWithProviders = 
RouterModule.forChild(routes)