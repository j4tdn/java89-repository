package com.springsecurity.test.dao;

import com.springsecurity.test.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
