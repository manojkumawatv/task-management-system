package com.mk.service;

import java.util.List;
import com.mk.entity.User;

import com.mk.dto.UserDTO;

public interface UserService {
	String createUser(UserDTO user);
	List<User> getUsers();
}
