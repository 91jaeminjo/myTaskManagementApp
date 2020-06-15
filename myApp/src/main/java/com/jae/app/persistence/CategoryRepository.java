package com.jae.app.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jae.app.domain.Category;
import com.jae.app.domain.Task;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{
	
	List<Category> findAll();
	Category findOneById(Integer id);
	
	@SuppressWarnings("unchecked")
	Category save(Category category);
	
	
	void delete(Category category);
	
}
