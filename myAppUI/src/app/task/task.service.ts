import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  
  taskUrl = "http://localhost:8080/Task"

  public tasks: BehaviorSubject<any> = new BehaviorSubject<any>([]);

  constructor(private http:HttpClient) { }

  getTasks(){
    return this.http.get(this.taskUrl)
  }

  showTasks(){
    this.getTasks()
    .subscribe((data:any)=>{
      this.tasks.next(data);
    });
  }

  saveTask(task){
    return this.http.post(this.taskUrl,task)
  }
}
