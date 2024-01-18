package com.mk.dto;

import java.time.LocalDate;

public class TaskDTO {
	private Integer id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private String userId;
	private String status;
	private String projectId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public TaskDTO(Integer id, String title, String description, LocalDate dueDate, String userId, String status,
			String projectId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.userId = userId;
		this.status = status;
		this.projectId = projectId;
	}
	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", userId=" + userId + ", status=" + status + ", projectId=" + projectId + "]";
	}
}