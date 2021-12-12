package com.springsecurity.test.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsecurity.test.entity.Customer;


@Repository
public class HibernateCustomerDao implements CustomerDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the customer ... finally
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query<?> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String param) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// Criteria criteria = currentSession.createCriteria(Customer.class);
//		criteria.add(Restrictions.like("firstName","%"+search+"%"));
//		criteria.add(Restrictions.like("lastName","%"+search+"%"));
//		criteria.add(Restrictions.like("email","%"+search+"%"));

		String sql = "SELECT * FROM customer \n" + "WHERE first_name LIKE :param\n" + "OR last_name LIKE :param";

		List<Customer> result = session.createNativeQuery(sql,Customer.class).setParameter("param","%"+param+"%").list();
		return result;
	}

}
