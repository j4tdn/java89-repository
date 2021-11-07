package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Customer;

@Repository
public class HibernateCustomerDao implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
		List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
//		session.close();
		

		return customers;
	}

}
