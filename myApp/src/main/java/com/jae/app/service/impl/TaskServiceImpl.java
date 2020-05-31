package com.jae.app.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jae.app.domain.Task;
import com.jae.app.persistence.TaskRepository;
import com.jae.app.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	@Override
	public List<Task> findTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task addTask(Task task) {

		task.setOriginationTime(Date.valueOf(LocalDate.now()));
		task.setIsComplete(false);
		task=taskRepository.save(task);
	
		return task;
	}

	@Override
	public Task markComplete(Task task) {
		task.setIsComplete(true);
		task.setCompletionTime(Date.valueOf(LocalDate.now()));
		taskRepository.save(task);
		return task;
	}

	@Override
	public Task markIncomplete(Task task) {
		task.setIsComplete(false);
		task.setCompletionTime(null);
		taskRepository.save(task);
		return task;
	}

	@Override
	public Task delete(Task task) {
		taskRepository.delete(task);
		return null;
	}

	@Override
	public List<Task> findTasksByCategory(Integer categoryId) {
		return taskRepository.findTasksByCategoryId(categoryId);
	}


}
