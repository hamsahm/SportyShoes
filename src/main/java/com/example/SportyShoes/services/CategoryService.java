package com.example.SportyShoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entity.Category;
import com.example.SportyShoes.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}

	public Category getCategoryByName(String categoryName) {
		return categoryRepository.findByName(categoryName);
	}

}
