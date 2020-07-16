package com.jae.app.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jae.app.domain.Category;
import com.jae.app.domain.Task;
import com.jae.app.service.TaskService;

@RestController
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
	
	/* To-do in future.
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping(value="/Task/Completed") public List<Task> completedTasks() {
	 * return taskService.findCompletedTasks(); }
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping(value="/Task/incomplete") public List<Task> incompleteTasks() {
	 * return taskService.findIncompleteTasks(); }
	 */
	
	@ResponseBody
	@PostMapping(value="/Task/MarkComplete")
	public Task markComplete(@RequestBody Task task){
		return taskService.markComplete(task); 
	}
	
	@ResponseBody
	@PostMapping(value="/Task/MarkIncomplete")
	public Task markIncomplete(@RequestBody Task task){
		return taskService.markIncomplete(task); 
	}
	
	@ResponseBody
	@PostMapping(value="/Task/Delete")
	public Task delete(@RequestBody Task task){
		return taskService.delete(task); 
	}
	
}
