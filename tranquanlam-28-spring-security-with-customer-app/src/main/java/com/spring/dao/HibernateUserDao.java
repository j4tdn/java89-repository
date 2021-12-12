package com.spring.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class HibernateUserDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger logger = Logger.getLogger(getClass().getName());

	private static String Q_FIND_BY_USER_NAME = "SELECT user FROM User user WHERE user.username = :username";

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		User user = null;
		try {
			return session.createQuery(Q_FIND_BY_USER_NAME, User.class).setParameter("username", userName)
					.getSingleResult();
		} catch (Exception e) {
			logger.warning("Username already exist ");
		}
		return user;
	}

	@Override
	public void save(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

}
