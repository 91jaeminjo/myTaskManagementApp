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

  markTaskComplete(task){
    return this.http.post(this.taskUrl + "/Complete", task)
  }

  markTaskIncomplete(task) {
    return this.http.post(this.taskUrl + "/Incomplete", task)
  }

  deleteTask(task){
    return this.http.post(this.taskUrl + "/Delete", task)
  }

  saveTask(task){
    return this.http.post(this.taskUrl,task)
  }
}
