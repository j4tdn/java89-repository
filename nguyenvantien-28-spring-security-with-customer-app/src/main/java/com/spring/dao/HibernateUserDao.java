package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class HibernateUserDao implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String Q_FIND_BY_USER_NAME = "SELECT user FROM User user WHERE user.username = :username";
	
	private static final String Q_GET_ALL_USERS = "SELECT user FROM User user";
	
	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = null;
		
		try {
			user = session.createQuery(Q_FIND_BY_USER_NAME, User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
		}
		
		return user;
	}
	
	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(Q_GET_ALL_USERS, User.class).getResultList();
	}
}
