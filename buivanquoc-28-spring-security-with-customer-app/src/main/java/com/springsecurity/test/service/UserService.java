package com.springsecurity.test.service;

import com.springsecurity.test.entity.User;
import com.springsecurity.test.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}


