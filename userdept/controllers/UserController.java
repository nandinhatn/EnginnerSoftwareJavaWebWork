package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserController {
	//criando endPoints
	
	@Autowired
	private UserRepository repository;
	
	//get all user
	@GetMapping
	public List<User> findAll(){
	
		List<User> result = repository.findAll();
		return result;
		
	}
	//get user com select
	@GetMapping(value="/{id}")
	public User findById( @PathVariable Long id){
	
		User result = repository.findById(id).get();
		return result;
		
	}
	//delelte user
	@DeleteMapping(value="/{id}")
	public User delete( @PathVariable Long id){
	
		User result = repository.findById(id).get();
		return result;
		
	}
	
	//update user
	@PutMapping(value="/{id}")
	public User update( @PathVariable Long id, @RequestBody User user){
	
		User entity = repository.getReferenceById(id);
		entity.update(user);
		return repository.save(entity);
		
	}
	
	//insert user
	@PostMapping
	public User insert(@RequestBody User user){
	
		User result = repository.save(user);
		return result;
		
	}
}
