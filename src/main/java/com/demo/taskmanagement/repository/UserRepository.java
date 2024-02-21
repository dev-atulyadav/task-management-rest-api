package com.demo.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.taskmanagement.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

}
