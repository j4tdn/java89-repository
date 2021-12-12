package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Repository
public class CustomerDaoIml implements CustomerDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Customer> getAll(SortOrder sortOrder) {
		Session session = sessionfactory.getCurrentSession();
		String sql = " SELECT * FROM customer";
		if (!sortOrder.getSqlOrder().isEmpty()) {
			sql += sortOrder.getSqlOrder();
		}

		return session.createNativeQuery(sql, Customer.class).getResultList();
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer get(int customerId) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void delete(Customer customer) {
		Session session = sessionfactory.getCurrentSession();
//		session.delete(customer);
		session.createQuery("DELETE FROM Customer WHERE id = :id").setParameter("id", customer.getId()).executeUpdate();
	}

	@Override
	public List<Customer> search(String param) {
		Session session = sessionfactory.getCurrentSession();
		String sql = "SELECT * FROM customer WHERE first_name LIKE :param OR last_name LIKE :param";
		return session.createNativeQuery(sql, Customer.class).setParameter("param", "%" + param + "%").getResultList();
	}

}
