package com.devsuperior.userdept.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	public User findById(Long id) {
		return repository.findById(id).get();
		
		
	}

}
