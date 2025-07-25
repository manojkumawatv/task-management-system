package com.mk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>  {
	List<Task> findByUserId(String UserId);
}