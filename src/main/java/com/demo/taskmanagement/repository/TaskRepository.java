package com.demo.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.taskmanagement.dto.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}
