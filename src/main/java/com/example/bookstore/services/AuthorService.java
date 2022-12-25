package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.Author;
import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;
import com.example.bookstore.repositories.AuthorRepository;
import com.example.bookstore.repositories.CategoryRepository;
import com.example.bookstore.repositories.UserRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepo;

	public Author getAuthorById(Integer a_id) {
		// TODO Auto-generated method stub
		Optional<Author> c = this.authorRepo.findById(a_id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		List<Author> authors = new ArrayList<>();
		this.authorRepo.findAll().forEach(c -> authors.add(c));
		return authors;
	}

	public Author addAuthor(Author c) {
		// TODO Auto-generated method stub
		return this.authorRepo.save(c);
	}

	public Author updateAuthor(Author author, Integer id) {
		// TODO Auto-generated method stub
		return this.authorRepo.save(author);
		
	}

	public Author deleteAuthor(Integer id) {
		// TODO Auto-generated method stub
		Optional<Author> c= this.authorRepo.findById(id);
		this.authorRepo.deleteById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
		
}
