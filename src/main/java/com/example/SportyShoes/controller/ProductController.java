package com.example.SportyShoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SportyShoes.entity.Product;
import com.example.SportyShoes.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> listProductsByCategory(
			@RequestParam(name = "categoryName", required = false) String categoryName) {
		List<Product> products = new ArrayList<Product>();
		if (categoryName != null) {
			products = productService.getProductsByCategory(categoryName);
		} else {
			products = productService.getAllProducts();
		}

		return products;

	}

}
