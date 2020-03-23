import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {

  taskViews
  constructor(private taskService: TaskService) { 

  }

  ngOnInit(){
    this.taskService.showTasks()
    this.taskService.tasks.subscribe((data)=>{
      this.taskViews=data
    })
  }

}
