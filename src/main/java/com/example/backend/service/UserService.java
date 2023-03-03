package com.example.backend.service;

import com.example.backend.model.User;

import java.util.*;

public interface UserService{

	//Save single user
	User saveUserService(User user);
	
	//Save multiple user
    List<User> saveUsersService(List<User> users);
	
	//Get All
	List<User> getAllUsersService();
	
	//Get single user
	User getUserById(long id);
	
	//Update user
	User updateUser(User user, long id);
	
	//Delete user
	void deleteUserById(long id);
	
}
