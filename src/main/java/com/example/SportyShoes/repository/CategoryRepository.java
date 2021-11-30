package com.example.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SportyShoes.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByName(String categoryName);

}
