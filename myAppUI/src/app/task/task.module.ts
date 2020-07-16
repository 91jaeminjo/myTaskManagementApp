import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { HomeComponent } from './home/home.component';
import { TaskComponent } from './task/task.component';
import { TaskFormComponent } from './task-form/task-form.component';
import { ReactiveFormsModule } from '@angular/forms'
import { MatDatepickerModule } from '@angular/material/datepicker'
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { NavigationComponent } from './navigation/navigation.component';
import { routing } from './task-routing.module';
import { LandingComponent } from './landing/landing.component';




@NgModule({
  declarations: [HomeComponent, TaskComponent, TaskFormComponent, NavigationComponent,LandingComponent],
  imports: [
    CommonModule,
    routing,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule

  ]
})
export class TaskModule { }
