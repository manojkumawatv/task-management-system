package com.mk.service;

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
		taskEntity.setId(task.getId());
		taskEntity.setTitle(task.getTitle());
		taskEntity.setDescription(task.getDescription());
		taskEntity.setUserId(task.getUserId());
		taskEntity.setProjectId(task.getProjectId());
		taskEntity.setStatus(task.getStatus());
		taskEntity.setDueDate(task.getDueDate());
		Task taskEntity2 = taskRepository.save(taskEntity);
		return taskEntity2.getId();
	}
}
