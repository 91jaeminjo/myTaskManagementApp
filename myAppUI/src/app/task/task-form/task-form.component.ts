import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {

  constructor(private taskService: TaskService) { }

  taskForm = new FormGroup({
    taskName: new FormControl('', Validators.required),
    originationTime: new FormControl(),
    completionTime: new FormControl(),
    dueDate: new FormControl(),
    description: new FormControl(),
    isComplete: new FormControl()
  });

  ngOnInit(): void {
  }

  addTask(){
    this.taskService.saveTask(this.taskForm.value)
    .subscribe((data:any)=>{
      console.log("inside task form: ",data)
      this.taskService.showTasks()
    })
  }

  onTaskSubmit(){
    console.log("inside submit")
    this.addTask()
    this.taskForm.reset();
  }

}
