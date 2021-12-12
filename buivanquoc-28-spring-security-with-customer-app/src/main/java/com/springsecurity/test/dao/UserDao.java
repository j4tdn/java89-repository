package com.springsecurity.test.dao;

import com.springsecurity.test.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
