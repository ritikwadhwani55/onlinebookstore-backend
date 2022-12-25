package com.example.bookstore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.models.User;
import com.example.bookstore.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		this.userRepo.findAll().forEach(( user) -> users.add((User)user) );
		return users;
	}
	
	public User getUserById(Integer id) {
		User u = new User();
		u.setUser_id(id);
		 Optional<User> user= this.userRepo.findById(id);
		 if(user.isPresent()) {
			 return user.get();
			
		 }
		 return null;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		User u =this.userRepo.save(user);
		return u;
	}

	public User updateAUser(User user, Integer id) {
		// TODO Auto-generated method stub
		return this.userRepo.save(user);
		
	}

	public User deleteUser(Integer id) {
		// TODO Auto-generated method stub
		User deletedUser= this.getUserById(id);
		this.userRepo.deleteById(id);
		return deletedUser;
	}

	
	
	
}
