package com.spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.model.UserModel;

@Service
public interface UserService extends UserDetailsService{

	User findByUserName(String username);

	void save(UserModel userModel);

	List<User> getAllUsers();

}
