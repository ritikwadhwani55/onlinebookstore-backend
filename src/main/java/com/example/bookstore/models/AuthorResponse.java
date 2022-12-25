package com.example.bookstore.models;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


public class AuthorResponse {
	
	private Integer a_id;
	public String getName() {
		return name;
	}
	public List<Integer> getBook_ids() {
		return book_ids;
	}
	public void setBook_ids(List<Integer> book_id) {
		this.book_ids = book_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	private String name;

	private List<Integer> book_ids;
	
	
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer c_id) {
		this.a_id = c_id;
	}
	
	public AuthorResponse(Integer a_id, String author) {
		super();
		this.a_id = a_id;
		this.name = author;
	}
	public AuthorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	