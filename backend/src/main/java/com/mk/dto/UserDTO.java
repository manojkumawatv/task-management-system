package com.mk.dto;

public class UserDTO {
	private Long id;
	private String username;
	private String emailId;
	private String password;
	public Long getUserId() {
		return id;
	}
	public void setUserId(Long id) {
		this.id = id;
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
}