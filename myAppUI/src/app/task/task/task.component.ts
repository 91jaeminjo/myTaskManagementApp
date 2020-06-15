import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {

  taskViews
  completedTasks
  constructor(private taskService: TaskService) { 

  }

  ngOnInit(){
    this.taskService.showTasks()
    this.taskService.tasks.subscribe((data)=>{
      this.taskViews=data
    })
  }

  markComplete(task){
    this.taskService.markTaskComplete(task)
      .subscribe((data: any) => {
        console.log("inside task form: ", data)
        this.taskService.showTasks()
      })
  }
  markIncomplete(task){
    this.taskService.markTaskIncomplete(task)
      .subscribe((data: any) => {
        console.log("inside task form: ", data)
        this.taskService.showTasks()
      })
  }
  delete(task){
    this.taskService.deleteTask(task)
      .subscribe((data: any) => {
        console.log("inside task form: ", data)
        this.taskService.showTasks()
      })
  }
}
