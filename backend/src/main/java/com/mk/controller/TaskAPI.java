
package com.mk.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mk.service.TaskService;
import com.mk.domain.Task;
import com.mk.dto.TaskDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TaskAPI {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	Environment environment;
	
	@GetMapping
	public List<Task> getAllTask() {
		return taskService.getAllTask();
	}
	
	//TODO
	@GetMapping("/{userId}")
	public List<Task> getAllTaskByUserId(@RequestParam Integer userId) {
		List<Task> tasks=taskService.getAllTaskByUser(userId);
		return tasks;
	}
	
	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody TaskDTO task){
		taskService.createTask(task);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + task.getId();
		ResponseEntity<String> response=new ResponseEntity<String>(successMessage, HttpStatus.OK);
		return response;
		
	}
}
