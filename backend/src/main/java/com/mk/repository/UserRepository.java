package com.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
