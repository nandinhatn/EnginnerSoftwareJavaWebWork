package com.devsuperior.userdept.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;
import com.devsuperior.userdept.services.execeptions.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(
				()-> new EntityNotFoundException("Id not found" + id));
		
		
	}
	
}
