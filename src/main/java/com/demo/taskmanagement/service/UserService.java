package com.demo.taskmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.taskmanagement.dto.User;
import com.demo.taskmanagement.response.ResponseStructure;

public interface UserService {

	public ResponseStructure<User> saveUserService(User user);

	public ResponseStructure<User> getUserByIdService(int id);

	public ResponseStructure<List<User>> getAllUserService();

	public ResponseStructure<User> getUserByEmailService(String email);

	public ResponseStructure<User> updateUserByEmailService(User user);

	public ResponseEntity<String> deleteUserByEmailService(String email);

	public ResponseStructure<User> getUserFromSessionService();

}
