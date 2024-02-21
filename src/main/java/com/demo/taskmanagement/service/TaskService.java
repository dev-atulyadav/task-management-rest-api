package com.demo.taskmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.taskmanagement.dto.TaskEntity;
import com.demo.taskmanagement.response.ResponseStructure;

public interface TaskService {

	public ResponseStructure<TaskEntity> saveTaskService(TaskEntity task);

	public ResponseStructure<TaskEntity> getTaskByIdService(int id);

	public ResponseStructure<List<TaskEntity>> getAllTaskService();

	public ResponseStructure<TaskEntity> updateTaskByIdService(TaskEntity task);

	public ResponseEntity<String> deleteTaskByIdService(int id);
}
