package com.jae.app.service;

import java.util.List;

import com.jae.app.domain.Task;

public interface TaskService {
	public List<Task> findAll();
	public Task addTask(Task task);
	public Task markComplete(Task task);
	public Task markIncomplete(Task task);
	public Task delete(Task task);
	public List<Task> findTasks();
	public List<Task> findTasksByCategory(Integer categoryId);
}
