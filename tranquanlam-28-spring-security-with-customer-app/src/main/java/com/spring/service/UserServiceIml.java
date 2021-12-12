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
public class UserServiceIml implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEndcoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(" ***UsernameNotFoundException ");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapToAuthorities(List<Role> roles) {
		return roles.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		// replace JdbcDaoImpl
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(UserModel userModel) {
		
		
		//Convert UserModel to User
		// b1:  Encrypt password user Bcrypt algorithm
		// b2: Assign default role to user
		User user = new User();
		user.setUserName(userModel.getUserName());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setPassword(passwordEndcoder.encode(userModel.getPassword()));
		user.setEmail(userModel.getEmail());
		user.setRoles(Arrays.asList(roleDao.findByRoleName(Role.EMPLOYEE)));
		userDao.save(user);
	}

}
