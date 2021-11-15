package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;

@Repository
public class HibernateCustomerDao implements CustomerDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}
	
	@Override
	public List<Customer> getCustomers(SortOrder sortOrder) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "SELECT * FROM customer";
		
		sql += sortOrder.getSqlOrder();
		
		System.out.println("SQL: " + sql);
		
		return currentSession.createNativeQuery(sql,Customer.class).getResultList();
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
		Query<?> theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}
	
	@Override
    public List<Customer> searchCustomers(String value) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        final String sql = "SELECT * FROM customer WHERE lower(first_name) LIKE :search OR lower(last_name) LIKE :search";
        
        Query<Customer> query = currentSession.createNativeQuery(sql, Customer.class);
        query.setParameter("search", '%' + value.toLowerCase() + '%');
        
        return query.getResultList();
        
    }
	
	

}











