package com.jae.app.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jae.app.domain.Category;
import com.jae.app.domain.Task;
import com.jae.app.service.TaskService;

@Controller
@CrossOrigin(origins="*",allowedHeaders="*")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@ResponseBody
	@GetMapping(value="/Task")
	public List<Task> showTasks(){
		return taskService.findTasks(); 
	}
	
	@ResponseBody
	@GetMapping(value="/Task/Category")
	public List<Task> showTasksByCategory(@RequestBody Category category){
		return taskService.findTasksByCategory(category.getId());
	}
	
	@ResponseBody
	@PostMapping(value="/Task")
	public Task addTask(@RequestBody Task task){
		return taskService.addTask(task); 
	}
		
	@ResponseBody
	@PostMapping(value="/Task/Complete")
	public Task markComplete(@RequestBody Task task){
		return taskService.markComplete(task); 
	}
	
	@ResponseBody
	@PostMapping(value="/Task/Incomplete")
	public Task markIncomplete(@RequestBody Task task){
		return taskService.markIncomplete(task); 
	}
	
	@ResponseBody
	@PostMapping(value="/Task/Delete")
	public Task delete(@RequestBody Task task){
		return taskService.delete(task); 
	}
	
}
