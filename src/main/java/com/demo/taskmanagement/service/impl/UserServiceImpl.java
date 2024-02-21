package com.demo.taskmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.taskmanagement.dao.UserDao;
import com.demo.taskmanagement.dto.User;
import com.demo.taskmanagement.response.ResponseStructure;
import com.demo.taskmanagement.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDao dao;
	@Autowired
	private ResponseStructure<User> structure;
	@Autowired
	private ResponseStructure<List<User>> structure2;

	@Override
	public ResponseStructure<User> saveUserService(User user) {
		User user2 = dao.getUserByEmailDao(user.getEmail());
		if (user2 == null) {
			dao.saveUserDao(user);
			session.setAttribute("userEmail", user.getEmail());
			structure.setMsg("Data Inserted!");
			structure.setStatus(HttpStatus.CREATED.value());
			user.setPassword("****");
			structure.setData(user);
		} else {
			structure.setData(null);
			structure.setMsg("User already Exist!!!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<User> getUserByIdService(int id) {
		User user = dao.getUserByIdDao(id);
		if (user != null) {
			user.setPassword("****");
			structure.setData(user);
			structure.setMsg("Data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(null);
			structure.setMsg("No record Found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<List<User>> getAllUserService() {
		List<User> list = dao.getAllUserDao();
		List<User> users = new ArrayList<User>();
		if (!list.isEmpty()) {
			for (User user : list) {
				user.setPassword("****");
				users.add(user);
			}
			structure2.setData(users);
			structure2.setMsg("Data found!!!");
			structure2.setStatus(HttpStatus.OK.value());
		} else {
			structure2.setData(null);
			structure2.setMsg("Data Not found!!!");
			structure2.setStatus(HttpStatus.OK.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<User> getUserByEmailService(String email) {
		User user = dao.getUserByEmailDao(email);
		if (user != null) {
			user.setPassword("****");
			structure.setData(user);
			structure.setMsg("Data found!!!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(null);
			structure.setMsg("No record Found!!!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<User> updateUserByEmailService(User user) {
		User user2 = dao.getUserByEmailDao(user.getEmail());
		if (user2 != null) {
			dao.updateUserByEmailDao(user);
			structure.setMsg("Data updated!!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(null);
			structure.setMsg("Invalid Details! No record Found!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> deleteUserByEmailService(String email) {
		boolean b = dao.deleteUserByEmailDao(email);
		if (b) {
			return new ResponseEntity<String>("Data Deleted!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No record found!", HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public ResponseStructure<User> getUserFromSessionService() {
		String email = (String) session.getAttribute("userEmail");
		if (email != null) {
			User user = dao.getUserByEmailDao(email);
			user.setPassword("****");
			structure.setData(user);
			structure.setMsg("already logged in!!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(null);
			structure.setMsg("Login again!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

}
