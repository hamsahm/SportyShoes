package com.example.SportyShoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SportyShoes.entity.Category;
import com.example.SportyShoes.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		categories = categoryService.getAllCategories();
		return categories;
	}

	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@DeleteMapping("/categories/{id}")
	public String deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return "Category Deleted successfully";
	}

}
