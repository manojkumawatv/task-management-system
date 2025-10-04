
package com.mk.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.mk.dto.TaskDTO;
import com.mk.entity.Task;
import com.mk.service.TaskService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = {"http://localhost:4200", "https://taskmanager-mkv.vercel.app/"})
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
	
	@GetMapping("/{userId}")
	public List<Task> getAllTaskByUserId(@RequestParam Integer userId) {
		List<Task> tasks = taskService.getAllTaskByUser(userId);
		return tasks;
	}
	
	@PostMapping
	public ResponseEntity<String> createTask(@RequestBody TaskDTO task){
		taskService.createTask(task);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + task.getId();
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateTask(@RequestParam Integer userId, @RequestBody TaskDTO task){
		taskService.updateTask(task);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS") + task.getId();
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer id){
		taskService.deleteTask(id);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS") + id;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}