package com.example.bookstore.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


enum Type {
    USER, ADMIN;
}
@Entity
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer user_id;
	private String name;
	@Column(unique=true)
	private String email;
	@Column(name="pwd")
	private String password;
	
	
	public User(Integer user_id, String name, String email, String password, Type type) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
	}
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(100) default 'USER'")
	private Type type;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer user_id, String name, String email, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
}
