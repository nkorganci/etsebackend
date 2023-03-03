package com.example.backend.controller;

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
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import java.util.*;


@RestController
@RequestMapping("/users")
public class UserController {

	// Service layer add info to repository
	@Autowired
	UserService userService;

//	@PostMapping("/save")
//	public ResponseEntity<User> saveUserController(@RequestBody User user) {
//		
//		return new ResponseEntity<User>(userService.saveUserService(user),HttpStatus.CREATED);
//	}

	// Postman[ {},{}...], for single post [{}]
	@PostMapping()
	public ResponseEntity<List<User>> saveUsersController(@RequestBody List<User> users) {

		return new ResponseEntity<List<User>>(userService.saveUsersService(users), HttpStatus.CREATED);
	}

	// GET ALL USER
	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getAllUsersService();
	}

	// GET SINGLE USER BY ID
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	// UPDATE  {}
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable ("id") long id, @RequestBody User user){		
		
		return new ResponseEntity<User>(userService.updateUser(user,  id), HttpStatus.OK);
	}
	
	//DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable("id") long id){
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
	}

}
