package com.mk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.dto.UserDTO;
import com.mk.entity.User;
import com.mk.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository repo;
	
	public String createUser(UserDTO user) {
		User userEntity=new User();
		userEntity.prepareUserEntity(user);
		repo.saveAndFlush(userEntity);
		return user.getUsername();
	}
}
