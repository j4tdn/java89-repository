package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Role;

@Repository
public class HibernateRoleDao implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final String Q_FIND_BY_ROLE_NAME = "SELECT * FROM Role WHERE name = :name";

	@Override
	public Role findByRoleName(String roleName) {
		Session session = sessionFactory.getCurrentSession();

		return session.createNativeQuery(Q_FIND_BY_ROLE_NAME, Role.class).setParameter("name", roleName).getSingleResult();
	}

}
