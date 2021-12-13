package com.spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoleDao;
import com.spring.dao.UserDao;
import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.model.UserModel;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// help use authentication and authorization bt default, check login
		
		User user = userDao.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapToAuthorities(user.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapToAuthorities(List<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public void save(UserModel userModel) {

		User user = new User();
		user.setUsername(userModel.getUserName());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		
		user.setRoles(Arrays.asList(roleDao.findByRoleName(Role.EMPLOYEE)));
		
		userDao.save(user);
	}
	
	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
