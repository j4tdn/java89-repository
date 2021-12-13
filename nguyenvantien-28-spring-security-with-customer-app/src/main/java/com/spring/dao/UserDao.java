package com.spring.dao;


import java.util.List;

import com.spring.entity.User;

public interface UserDao {
	User findByUserName(String username);
	void save(User user);
	List<User> getAllUsers();
}
