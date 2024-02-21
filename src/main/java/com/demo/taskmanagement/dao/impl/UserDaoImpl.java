package com.demo.taskmanagement.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.taskmanagement.dao.UserDao;
import com.demo.taskmanagement.dto.User;
import com.demo.taskmanagement.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUserDao(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserByIdDao(int id) {
		try {

			return repository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public List<User> getAllUserDao() {
		return repository.findAll();
	}

	@Override
	public User getUserByEmailDao(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public User updateUserByEmailDao(User user) {
		return repository.save(user);
	}

	@Override
	public boolean deleteUserByEmailDao(String email) {
		User user = getUserByEmailDao(email);
		if (user != null) {
			repository.delete(user);
			return true;
		} else {
			return false;
		}
	}

}