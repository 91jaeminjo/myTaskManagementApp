import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {
  value
  display
  categories
  uncategorizedFound = false
  constructor(private taskService: TaskService) { 
    
  }

  taskForm = new FormGroup({
    taskName: new FormControl('', Validators.required),
    category: new FormControl(),
    newCategory: new FormControl(),
    originationTime: new FormControl(),
    completionTime: new FormControl(),
    dueDate: new FormControl(),
    description: new FormControl(),
    isComplete: new FormControl()
  });

  
  ngOnInit() {
    this.getCategoriesInit()   
  }

  getCategoriesInit(){
    this.taskService.fetchCategories()
    .subscribe((data:any)=>{
      this.categories=data;
      console.log("categories: ", data)
      this.uncategorizedFound = !data.every(element => {
        element.category != "uncategorized"
      })
      if (this.uncategorizedFound == false) {
        var newValue = {
          id: 0,
          category: "uncategorized"
        }
        this.taskService.addNewCategory(newValue)
        .subscribe((data: any) => {
          console.log("addNewCategory data: ", data)
          this.categories = data;
        })
      }
    })
  }

  getCategories() {
    this.taskService.fetchCategories()
      .subscribe((data: any) => {
        this.categories = data;
        console.log("categories: ", data)
      })
  }

  toggleCategoryDisplay(){
    this.display=true;
  }

  addCategory(){
    console.log(this.taskForm.value.newCategory);
    var duplicate=false;
    var newValue = {
      id: 0,
      category: this.taskForm.value.newCategory
    }
    this.categories.forEach(element => {
      if(element.category == newValue.category){
        duplicate=true;
  
      }

    });
    if(!duplicate){
    this.taskForm.value.category = newValue;
    this.taskService.addNewCategory(newValue)
      .subscribe((data: any) => {
        console.log("inside addCategory")
        this.getCategories()
      })
    }
    else{
      console.log("duplicate!");
    }
  }

  addTask(){
    if(this.taskForm.value.category==null){
      var newCategory = this.categories.filter((element) => {
        if(element.category == "uncategorized"){
          return element
        }
      })
      console.log("newCategory : ", newCategory)
      this.taskForm.patchValue({
        category: {
          'id':newCategory[0].id,
          'category':newCategory[0].category
        }
      })
      console.log("taskform value: ", this.taskForm.value)
    }
    else{
      console.log("taskform value: ",this.taskForm.value)
    }
    //this.taskService.saveTask(this.taskForm.value)
    //.subscribe((data:any)=>{
    //  console.log("inside task form")
    //  this.taskService.showTasks()
    //})
  }

  onTaskSubmit(){
    console.log("inside submit")
    this.addTask()
    this.taskForm.reset();
  }
}
