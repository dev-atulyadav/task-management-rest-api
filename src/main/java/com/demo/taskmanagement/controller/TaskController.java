package com.demo.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.taskmanagement.dto.TaskEntity;
import com.demo.taskmanagement.response.ResponseStructure;
import com.demo.taskmanagement.service.TaskService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService service;

	@PostMapping(value = "/insert")
	public ResponseStructure<TaskEntity> saveTaskController(@RequestBody TaskEntity task) {
		return service.saveTaskService(task);
	}

	@GetMapping(value = "/getById/{id}")
	public ResponseStructure<TaskEntity> getTaskByIdController(@PathVariable int id) {
		return service.getTaskByIdService(id);
	}

	@GetMapping(value = "/getAllTask")
	public ResponseStructure<List<TaskEntity>> getAllTaskController() {
		return service.getAllTaskService();
	}

	@PutMapping(value = "/updateById")
	public ResponseStructure<TaskEntity> updateTaskByIdController(@RequestBody TaskEntity task) {
		return service.updateTaskByIdService(task);
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> deleteTaskByIdController(@PathVariable int id) {
		return service.deleteTaskByIdService(id);
	}

	@PutMapping("/updateStatus/{id}")
	public ResponseEntity<String> updateTaskSatusByIdController(@PathVariable int id) {
		return service.updateTaskSatusByIdController(id);
	}

}
