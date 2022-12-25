package com.example.bookstore.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer c_id;
	@Column(unique=true)
	private String category;
	@ManyToMany(mappedBy="categories")
	@JsonIgnore
	private List<Book> books;
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Category(Integer c_id, String category) {
		super();
		this.c_id = c_id;
		this.category = category;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	