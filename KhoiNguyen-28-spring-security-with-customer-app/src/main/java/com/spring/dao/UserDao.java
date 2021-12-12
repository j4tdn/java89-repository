package com.spring.dao;

import org.springframework.security.core.userdetails.User;

public interface UserDao {
	User findByUserName(String username);

	void save(com.spring.entity.User user);

}
