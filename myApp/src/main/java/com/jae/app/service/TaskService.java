package com.jae.app.service;

import java.util.List;

import com.jae.app.domain.Task;

public interface TaskService {
	public List<Task> findAll();
	public Task addTask(Task task);
	
}
