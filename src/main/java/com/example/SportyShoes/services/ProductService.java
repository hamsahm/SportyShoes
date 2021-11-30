package com.example.SportyShoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entity.Category;
import com.example.SportyShoes.entity.Product;
import com.example.SportyShoes.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryService categoryService;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public List<Product> getProductsByCategory(String categoryName) {

		Category category = categoryService.getCategoryByName(categoryName);
		List<Product> products = productRepository.findByCategoryId(category.getId());
		return products;
	}

}
