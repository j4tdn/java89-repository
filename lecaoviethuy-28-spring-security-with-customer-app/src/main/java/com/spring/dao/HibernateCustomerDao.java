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
		List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();

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
	public Customer get(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void delete(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Customer WHERE id= :id")
				.setParameter("id", customerId)
				.executeUpdate();
	}

	@Override
	public List<Customer> search(String searchValue) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * FROM Customer WHERE first_name LIKE :searchValue or last_name LIKE :searchValue", Customer.class)
				.setParameter("searchValue", "%" + searchValue + "%")
				.getResultList();
	}

}
