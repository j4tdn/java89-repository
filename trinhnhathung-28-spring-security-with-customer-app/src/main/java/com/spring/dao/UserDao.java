package com.spring.dao;

import com.spring.entity.User;

public interface UserDao {

	User findByUsername(String username);

	void save(User user);

}
