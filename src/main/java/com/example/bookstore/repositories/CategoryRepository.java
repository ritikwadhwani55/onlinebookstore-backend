package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
