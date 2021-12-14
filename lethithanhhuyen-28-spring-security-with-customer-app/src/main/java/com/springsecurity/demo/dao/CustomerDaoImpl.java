package com.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.demo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery("FROM customer", Customer.class).getResultList();

		return customers;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	@Transactional
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM customer WHERE id= :id")
				.setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public List<Customer> search(String name) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM customer WHERE first_name LIKE :name or last_name LIKE :name", Customer.class)
				.setParameter("name", "%" + name + "%")
				.getResultList();
	}

}