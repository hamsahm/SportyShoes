package com.example.SportyShoes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SportyShoes.entity.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByOrderedDateAndCategoryId(LocalDate date, int categoryId);

}
