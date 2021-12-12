package com.spring.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserDao implements UserDao {
	private Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private SessionFactory sessionFactory;

	private static final String Q_FIND_BY_USER_NAME = "SELECT user FROM User user WHERE user.username = :username";

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.getCurrentSession();
		com.spring.entity.User user= null;
		try {
			user = session.createQuery(Q_FIND_BY_USER_NAME, User.class)
					.setParameter("username", username)
				.getSingleResult();
		} catch (Exception e) {
			logger.warning("username already exist");
		}
		return user;
	}

	@Override
	public void save(com.spring.entity.User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

}
