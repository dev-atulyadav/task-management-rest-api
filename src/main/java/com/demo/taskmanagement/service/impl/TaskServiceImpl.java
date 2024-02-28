package com.demo.taskmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.taskmanagement.dao.TaskDao;
import com.demo.taskmanagement.dto.TaskEntity;
import com.demo.taskmanagement.response.ResponseStructure;
import com.demo.taskmanagement.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao dao;
	@Autowired
	private ResponseStructure<TaskEntity> structure;
	@Autowired
	private ResponseStructure<List<TaskEntity>> structure2;

	@Override
	public ResponseStructure<TaskEntity> saveTaskService(TaskEntity task) {
		TaskEntity task2 = dao.getTaskById(task.getId());
		if (task2 == null) {
			dao.saveTaskDao(task);
			structure.setMsg("Data Stored!");
			structure.setData(task);
			structure.setStatus(HttpStatus.CREATED.value());
		} else {
			structure.setData(null);
			structure.setMsg("Data not inserted!");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<TaskEntity> getTaskByIdService(int id) {
		TaskEntity task = dao.getTaskById(id);
		if (task != null) {
			structure.setData(task);
			structure.setMsg("Data Found!");
			structure.setStatus(HttpStatus.FOUND.value());
		} else {
			structure.setData(null);
			structure.setMsg("Data not found!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseStructure<List<TaskEntity>> getAllTaskService() {
		List<TaskEntity> tasks = dao.getAllTaskDao();
		if (!tasks.isEmpty()) {
			structure2.setData(tasks);
			structure2.setMsg("Data found!");
			structure2.setStatus(HttpStatus.FOUND.value());
		} else {
			structure2.setData(null);
			structure2.setMsg("No data found!");
			structure2.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure2;
	}

	@Override
	public ResponseStructure<TaskEntity> updateTaskByIdService(TaskEntity task) {
		TaskEntity task2 = dao.getTaskById(task.getId());
		if (task2 != null) {
			dao.updateTaskById(task);
			structure.setData(task);
			structure.setMsg("Data updated!");
			structure.setStatus(HttpStatus.OK.value());
		} else {
			structure.setData(null);
			structure.setMsg("No data found!");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return structure;
	}

	@Override
	public ResponseEntity<String> deleteTaskByIdService(int id) {
		boolean b = dao.deleteTaskById(id);
		if (b) {
			return new ResponseEntity<String>("Data deleted!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not deleted!", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> updateTaskSatusByIdService(int id) {
		TaskEntity task = dao.getTaskById(id);
		if (task != null) {
			task.setStatus("completed");
			if (dao.updateTaskById(task) != null) {
				return new ResponseEntity<String>("Task updated!", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Task not updated!", HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<String>("Task not found!", HttpStatus.NOT_ACCEPTABLE);

		}
	}
}
