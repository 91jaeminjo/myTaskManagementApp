package com.jae.app.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jae.app.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long>{
	
	List<Task> findAll();
	Task findOneById(Integer id);
	
	@SuppressWarnings("unchecked")
	Task save(Task task);

	/* To do in future
	 * List<Task> findByCompletionDateIsNull(); 
	 * List<Task> findByCompletionDateIsNotNull();
	 */
	List<Task> findTasksByCategoryId(Integer categoryId);
	
	
	
}
