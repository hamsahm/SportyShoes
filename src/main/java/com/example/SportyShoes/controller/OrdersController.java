package com.example.SportyShoes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SportyShoes.entity.Orders;
import com.example.SportyShoes.exception.InvalidDateFormatException;
import com.example.SportyShoes.services.OrderService;

@RestController
public class OrdersController {

	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public List<Orders> getAllOrders(@RequestParam(name = "date", required = false) String date,
			@RequestParam(name = "categoryName", required = false) String categoryName) {

		List<Orders> orders = new ArrayList<Orders>();

		if (date != null && categoryName != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			LocalDate newDate = LocalDate.now();
			try {
				newDate = new java.sql.Date(format1.parse(date).getTime()).toLocalDate();
			} catch (ParseException e) {
				throw new InvalidDateFormatException();
			}
			orders = orderService.getAllOrdersByDateAndCategory(newDate, categoryName);
		} else {
			orders = orderService.getAllOrders();
		}

		return orders;
	}

}
