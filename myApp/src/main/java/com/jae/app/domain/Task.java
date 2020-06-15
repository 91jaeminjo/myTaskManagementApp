package com.jae.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(name="taskName")
	String taskName;
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category;
	@Column(name="originationTime")
	Date originationTime;
	@Column(name="completionTime")
	Date completionTime;
	@Column(name="dueDate")
	Date dueDate;
	@Column(name="description")
	String description;
	@Column(name="isComplete")
	Boolean isComplete;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Date getOriginationTime() {
		return originationTime;
	}
	public void setOriginationTime(Date originationTime) {
		this.originationTime = originationTime;
	}
	public Date getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(Date completionTime) {
		this.completionTime = completionTime;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
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
	public Task(Integer id, String taskName, com.jae.app.domain.Category category, Date originationTime,
			Date completionTime, Date dueDate, String description, Boolean isComplete) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.category = category;
		this.originationTime = originationTime;
		this.completionTime = completionTime;
		this.dueDate = dueDate;
		this.description = description;
		this.isComplete = isComplete;
	}	
}
