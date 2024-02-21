package com.demo.taskmanagement.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.taskmanagement.dao.TaskDao;
import com.demo.taskmanagement.dto.TaskEntity;
import com.demo.taskmanagement.repository.TaskRepository;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private TaskRepository repository;

	@Override
	public TaskEntity saveTaskDao(TaskEntity task) {
		return repository.save(task);
	}

	@Override
	public TaskEntity getTaskById(int id) {
		try {
			return repository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public TaskEntity updateTaskById(TaskEntity task) {
		return repository.save(task);
	}

	@Override
	public boolean deleteTaskById(int id) {
		TaskEntity task = getTaskById(id);
		if (task != null) {
			repository.delete(task);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<TaskEntity> getAllTaskDao() {
		return repository.findAll();
	}

}
