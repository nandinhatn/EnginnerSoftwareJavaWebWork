package com.devsuperior.userdept.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.devsuperior.userdept.services.UserService;
import com.devsuperior.userdept.services.execeptions.EntityNotFoundException;
import com.devsuperior.userdept.services.execeptions.StandardError;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
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
	public ResponseEntity<User> findById( @PathVariable Long id){
		
	
			User result = userService.findById(id);
			return ResponseEntity.ok().body(result);
		
		
	
		
		
	}
	//delelte user
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> delete( @PathVariable("id") Long id){
	
		User result = userService.findById(id);
		repository.deleteById(id);
	
		return ResponseEntity.ok().body(result);
		
	}
	
	//update user
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update( @PathVariable Long id, @RequestBody User user){
	
		User entity = userService.findById(id);
		entity.update(user);
		repository.save(entity);
		return ResponseEntity.ok().body(entity);
		
	}
	
	//insert user
	@PostMapping
	public User insert(@RequestBody User user){
	
		User result = repository.save(user);
		return result;
		
	}
}
