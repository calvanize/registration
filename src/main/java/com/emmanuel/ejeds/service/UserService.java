package com.emmanuel.ejeds.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emmanuel.ejeds.dao.UserRepository;
import com.emmanuel.ejeds.data.User;
import com.emmanuel.ejeds.web.UserForm;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User registerNewUser(UserForm userForm) {
		if(userRepository.findByUsername(userForm.getEmail()).isPresent()) {
			throw new RuntimeException("There is an account with that email address");
		}
		
		User user = new User();
		user.setFirstname(userForm.getFirstname());
		user.setLastname(userForm.getLastname());
		user.setUsername(userForm.getEmail());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		return userRepository.save(user);
	}
	
	public Optional<User> findByUsername(String username){
		return userRepository.findByUsername(username);
	}

}
