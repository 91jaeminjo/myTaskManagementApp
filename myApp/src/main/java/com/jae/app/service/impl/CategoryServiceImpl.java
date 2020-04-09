package com.jae.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jae.app.domain.Category;
import com.jae.app.persistence.CategoryRepository;
import com.jae.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		category = categoryRepository.save(category);
		return category;
	}
	
	
}
