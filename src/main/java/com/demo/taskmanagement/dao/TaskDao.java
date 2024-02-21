package com.demo.taskmanagement.dao;

import java.util.List;

import com.demo.taskmanagement.dto.TaskEntity;

public interface TaskDao {

	public TaskEntity saveTaskDao(TaskEntity task);

	public TaskEntity getTaskById(int id);

	public TaskEntity updateTaskById(TaskEntity task);

	public boolean deleteTaskById(int id);
	
	public List<TaskEntity> getAllTaskDao();

}
