package com.jae.app.service.impl;

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
	public Task addTask(Task task) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime current = LocalDateTime.now();
		task.setId(taskRepository.count()+1);
		task.setOriginationTime(dtf.format(current));
		
		task=taskRepository.save(task);
	
		return task;
	}
}
