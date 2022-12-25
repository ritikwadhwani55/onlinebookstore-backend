package com.example.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.models.User;
import com.example.bookstore.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/greetings")
	public String getResp() {
		return "Hello!!";
	}
	
	@RequestMapping("/")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	@RequestMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer user_id) {
		return this.userService.getUserById(user_id);
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public User addUser(@RequestBody() User user) {
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable("id") Integer id, @RequestBody() User user) {
		return this.userService.updateAUser(user, id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public User deleteUserById(@PathVariable("id") Integer id) {
		return this.userService.deleteUser(id);
	}
}
