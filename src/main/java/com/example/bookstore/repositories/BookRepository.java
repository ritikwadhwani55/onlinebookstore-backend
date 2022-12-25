package com.example.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.models.Book;
import com.example.bookstore.models.User;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
