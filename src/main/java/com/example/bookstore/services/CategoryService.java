package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;
import com.example.bookstore.repositories.CategoryRepository;
import com.example.bookstore.repositories.UserRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;

	public Category getCategoryById(Integer c_id) {
		// TODO Auto-generated method stub
		Optional<Category> c = this.categoryRepo.findById(c_id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<>();
		this.categoryRepo.findAll().forEach(c -> categories.add(c));
		return categories;
	}

	public Category addCategory(Category c) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(c);
	}

	public Category updateACategory(Category category, Integer id) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
		
	}

	public Category deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		Optional<Category> c= this.categoryRepo.findById(id);
		this.categoryRepo.deleteById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
		
}
