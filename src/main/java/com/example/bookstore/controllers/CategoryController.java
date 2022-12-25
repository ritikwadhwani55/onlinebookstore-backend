package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.Category;
import com.example.bookstore.models.User;
import com.example.bookstore.services.CategoryService;
import com.example.bookstore.services.UserService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/greetings")
	public String getResp() {
		return "Hello!!";
	}
	
	@RequestMapping("/")
	public List<Category> getAllCategories() {
		return this.categoryService.getAllCategories();
	}
	@RequestMapping("/{id}")
	public Category getCategoryById(@PathVariable("id") Integer c_id) {
		return this.categoryService.getCategoryById(c_id);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public Category addCategory(@RequestBody() Category c) {
		return this.categoryService.addCategory(c);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Category updateCategory(@PathVariable("id") Integer id, @RequestBody() Category category) {
		return this.categoryService.updateACategory(category, id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public Category deleteCategoryById(@PathVariable("id") Integer id) {
		return this.categoryService.deleteCategory(id);
	}
}

