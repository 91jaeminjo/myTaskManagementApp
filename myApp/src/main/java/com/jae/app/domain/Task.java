package com.jae.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="taskName")
	String taskName;
	@Column(name="originationTime")
	String originationTime;
	@Column(name="completionTime")
	String completionTime;
	@Column(name="dueDate")
	String dueDate;
	@Column(name="description")
	String description;
	@Column(name="isComplete")
	Boolean isComplete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getOriginationTime() {
		return originationTime;
	}
	public void setOriginationTime(String originationTime) {
		this.originationTime = originationTime;
	}
	public String getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}	
	public Task() {
	}
	
	public Task(Long id, String taskName, String originationTime, String completionTime, String description,
			Boolean isComplete) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.originationTime = originationTime;
		this.completionTime = completionTime;
		this.description = description;
		this.isComplete = isComplete;
	}
	
	
	
}
