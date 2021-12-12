package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Role;
import com.spring.entity.User;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final String Q_FIND_BY_NAME = "SELECT role FROM Role role WHERE role.name = :name";

	@Override
	public Role findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery(Q_FIND_BY_NAME, Role.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
