package com.demo.taskmanagement.dao;

import java.util.List;

import com.demo.taskmanagement.dto.TaskEntity;
import com.demo.taskmanagement.dto.User;

public interface UserDao {

	public User saveUserDao(User user);

	public User getUserByIdDao(int id);

	public List<User> getAllUserDao();

	public User getUserByEmailDao(String email);

	public User updateUserByEmailDao(User user);

	public boolean deleteUserByEmailDao(String email);

	public User updateUserTaskByUserEmailDao(String email, TaskEntity task);

}
