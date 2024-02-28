package com.demo.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.taskmanagement.dto.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

	@Query(value = "select * from user_tasks where tasks_id = ?1", nativeQuery = true)
	public TaskEntity deleteTaskByUserEmail(int id);
	
}
