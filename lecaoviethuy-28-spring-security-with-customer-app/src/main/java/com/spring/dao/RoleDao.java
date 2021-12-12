package com.spring.dao;

import com.spring.entity.Role;

public interface RoleDao {
    Role findByName(String name);
}
