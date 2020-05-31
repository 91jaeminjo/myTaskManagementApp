package com.jae.app.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jae.app.domain.Category;
import com.jae.app.service.CategoryService;

@Controller
@CrossOrigin(origins="*",allowedHeaders="*")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@ResponseBody
	@GetMapping(value="/Categories")
	public List<Category> showCategories(){
		return categoryService.findAll();
	}
	
	@ResponseBody
	@PostMapping(value="/Categories")
	public Category addCategory(@RequestBody Category category){
		return categoryService.addCategory(category);
	}
	
	@ResponseBody
	@DeleteMapping(value="/Categories")
	public Category deleteCategory(@RequestBody Category category){
		return categoryService.deleteCategory(category);
	}
}
