package com.jae.app.service;

import java.util.List;

import com.jae.app.domain.Category;

public interface CategoryService {
	public List<Category> findAll();
	public Category addCategory(Category category);
}
