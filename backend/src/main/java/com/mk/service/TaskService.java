package com.mk.service;

import java.util.List;

import com.mk.dto.TaskDTO;
import com.mk.entity.Task;

public interface TaskService {
	public Integer createTask(TaskDTO task);
	public List<Task> getAllTask();
	public List<Task> getAllTaskByUser(Integer id);
}