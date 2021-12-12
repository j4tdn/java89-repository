package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String Q_FIND_BY_USER_NAME = "SELECT user FROM User user WHERE user.username = :username";

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			return session.createQuery(Q_FIND_BY_USER_NAME, User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void save(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(user);
	}
	
}
