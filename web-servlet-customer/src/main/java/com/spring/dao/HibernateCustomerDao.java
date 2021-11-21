package com.spring.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Repository
public class HibernateCustomerDao implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	// quan li transaction tu dong, khong can goi beginTransaction() de quan li transaction, commit rollback tu dong
	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Customer", Customer.class).getResultList();
	}
	
	@Override
	public List<Customer> getAll(SortOrder sortOrder) {
		// sortOrder#sortParams{new SortParam(first_name, true), new SortParam(last_name, true)}
		Session session = sessionFactory.getCurrentSession();
		
		return session.createNativeQuery("SELECT * FROM customer" + sortOrder.getSqlOrder(), Customer.class).getResultList();
	}
	
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
	
	@Override
	public Customer get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	
	@Override
	public void delete(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
	}
	
	@Override
	public List<Customer> find(String value) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Customer WHERE firstName LIKE :firstName OR lastName LIKE :lastName OR email LIKE :email";
		return session.createQuery(hql, Customer.class)
				.setParameter("firstName", "%"+value+"%")
				.setParameter("lastName", "%"+value+"%")
				.setParameter("email", "%"+value+"%")
				.getResultList();
	}
	
}
