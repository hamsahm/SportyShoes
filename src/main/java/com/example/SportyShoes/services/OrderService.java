package com.example.SportyShoes.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SportyShoes.entity.Category;
import com.example.SportyShoes.entity.Orders;
import com.example.SportyShoes.repository.OrdersRepository;

@Service
public class OrderService {

	@Autowired
	OrdersRepository ordersRepository;

	@Autowired
	CategoryService categoryService;

	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public List<Orders> getAllOrdersByDateAndCategory(LocalDate date, String categoryName) {

		Category category = categoryService.getCategoryByName(categoryName);
		List<Orders> orders = ordersRepository.findByOrderedDateAndCategoryId(date, category.getId());
		return orders;
	}

}
