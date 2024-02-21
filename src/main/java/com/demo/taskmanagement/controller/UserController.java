package com.demo.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.taskmanagement.dto.User;
import com.demo.taskmanagement.response.ResponseStructure;
import com.demo.taskmanagement.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(value = "/insert")
	public ResponseStructure<User> saveUserController(@RequestBody User user) {
		return service.saveUserService(user);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<User> getUserByIdController(@PathVariable int id) {
		return service.getUserByIdService(id);
	}

	@GetMapping(value = "/getAllData")
	public ResponseStructure<List<User>> getAllUserController() {
		return service.getAllUserService();
	}

	@GetMapping(value = "/getByEmail/{email}")
	public ResponseStructure<User> getUserByEmailController(@PathVariable String email) {
		return service.getUserByEmailService(email);
	}

	public ResponseStructure<User> updateUserByEmailCOntroller(@RequestBody User user) {
		return service.updateUserByEmailService(user);
	}

	@DeleteMapping(value = "/deleteByEmail/{email}")
	public ResponseEntity<String> deleteUserEmailController(@PathVariable String email) {
		return service.deleteUserByEmailService(email);
	}

	@GetMapping(value = "/getCurrentSession")
	public ResponseStructure<User> getUserFromSessionService() {
		return service.getUserFromSessionService();
	}

}
