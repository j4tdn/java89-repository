package com.spring.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoleDao;
import com.spring.dao.UserDao;
import com.spring.model.UserModel;
import com.spring.entity.Role;
//import com.spring.entity.User;
@Service
public class UserServiceImpl implements customerService {

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;	
	}

	@Override
	@Transactional
	public com.spring.entity.User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void save(UserModel userModel) {
		// Convert UserModel to UserEntity
		//b1: Encrypt password user BCrypt algorithm
		//b2: Assign default role to user
		
		
		
		com.spring.entity.User user = new com.spring.entity.User();
		user.setUsername(userModel.getUserName());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		user.setRoles(Arrays.asList(roleDao.findByRoleName(Role.EMPLOYEE)));
		
		userDao.save(user);
		
	}

}
