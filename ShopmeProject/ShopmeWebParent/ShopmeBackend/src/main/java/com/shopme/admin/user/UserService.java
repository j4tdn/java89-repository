package com.shopme.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll() {
		return (List<User>) repository.findAll();
	}
	
	public List<Role> listRoles() {
		return (List<Role>) roleRepository.findAll();
	}
	
	public User get(Integer id) throws UserNotFoundException {
		try {
			return repository.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("Could not find any user with ID " + id);
		}
	}
	
	public User save(User user) {
		boolean isUpdatingUser = (user.getId() != null);
		
		
		if (isUpdatingUser) {
			// update mode
			User existingUser = repository.findById(user.getId()).get();
			
			// not change the password, leave field blank
			if (user.getPassword().isEmpty()) {
				user.setPassword(existingUser.getPassword());
			} else {
				encodePassword(user);
			}
		} else {	
			// add mode
			encodePassword(user);
		}
		
		return repository.save(user);
	}
	
	public void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
	public boolean isEmailUnique(Integer id, String email) {
		User userByEmail = repository.getUserByEmail(email);
		
		if (userByEmail == null) return true;
		
		boolean isCreatingNew = (id == null);
		
		if (isCreatingNew) {
			if (userByEmail != null) return false;
		} else {
			// updating mode
			// userByEmail existed in database with another id
			// --> email already existed
			if (userByEmail.getId() != id) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public void delete(Integer id) throws UserNotFoundException {
		Long countById = repository.countById(id);
		if (countById == null || countById == 0) {
			throw new UserNotFoundException("Could not find any user with ID " + id);
		}
		
		repository.deleteById(id);
	}
}
