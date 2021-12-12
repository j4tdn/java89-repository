package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class HibernateDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String Q_FIND_BY_USER_NAME = "SELECT * FROM User WHERE username = :username";

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();

		User user =null; 
		try {
			user = session.createNativeQuery(Q_FIND_BY_USER_NAME, User.class).setParameter("username", username)
			.getSingleResult();
		} catch (Exception e) { 
			
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

}
