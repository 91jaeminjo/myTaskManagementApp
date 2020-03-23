package com.jae.app.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jae.app.domain.Task;
import com.jae.app.service.TaskService;

@Controller
@CrossOrigin(origins="*",allowedHeaders="*")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@ResponseBody
	@GetMapping(value="/Task")
	public List<Task> showAllTasks(){
		return taskService.findAll(); 
	}
	
	@ResponseBody
	@PostMapping(value="/Task")
	public Task addTask(@RequestBody Task task){
		return taskService.addTask(task); 
	}
	
	
	
}
