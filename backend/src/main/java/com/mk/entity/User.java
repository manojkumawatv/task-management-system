package com.mk.entity;

import com.mk.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name="user_id")
	private Long userId;
	private String username;
	@Column(name="email_id")
	private String emailId;
	private String password;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void prepareUserEntity(UserDTO user) {
		this.userId=user.getUserId();
		this.username=user.getUsername();
		this.emailId=user.getEmailId();
		this.password=user.getUsername();
	}
}