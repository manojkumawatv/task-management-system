package com.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.domain.Task;
import com.mk.dto.TaskDTO;
import com.mk.repository.TaskRepository;

@Service("taskService")
@Transactional
public class TaskServiceImp implements TaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Override
	public Integer createTask(TaskDTO task) {
		Task taskEntity = new Task();
		taskEntity.prepareTaskEntity(task);
		taskRepository.saveAndFlush(taskEntity);
		return taskEntity.getId();
	}
	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	@Override
	public List<Task> getAllTaskByUser(Integer id) {
		return taskRepository.findByUserId(id.toString());
	}
}