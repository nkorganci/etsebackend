package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	// Save One user
	@Override
	public User saveUserService(User user) {
		return userRepository.save(user);
	}

	// Save many users
	@Override
	public List<User> saveUsersService(List<User> users) {
		return userRepository.saveAll(users);
	}

	// Get All users
	@Override
	public List<User> getAllUsersService() {
		return userRepository.findAll();
	}

	// Get single user
	@Override
	public User getUserById(long id) {

		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

	}

	// Update user
	@Override
	public User updateUser(User user, long id) {

		// We need to check weather user with given id in DB
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());

		userRepository.save(existingUser);

		return existingUser;
	}

	// Delete single user
	@Override
	public void deleteUserById(long id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);

	}

}
