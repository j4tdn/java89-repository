package com.spring.dao;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Param;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Customer;
import com.spring.sorting.SortOrder;
import com.spring.sorting.SortParam;

@Repository
public class HibernateCustomerDao implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public List<Customer> getAll() {
		Session session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
		List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
//		session.close();

		return customers;
	}

	@Override
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
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Customer WHERE id =:id").setParameter("id", id).executeUpdate();
	}

	@Override
	public List<Customer> search(String param) {
		// search by firstName , lastName, email with case insensitive
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "select *from customer \n" + "where first_name like :param \n" + "or last_name like :param ";

		return session.createNativeQuery(sql, Customer.class).setParameter("param", "%" + param + "%").getResultList();
	}

	@Override
	public List<Customer> getAll(SortOrder sortOrder) {
		Session session = sessionFactory.getCurrentSession();
		//		String sql="SELECT * FROM customer"+sortOrder.getSqlOrder();
	
//		List<SortParam> sortParams = sortOrder.getSortParams();
//		for(SortParam sortParam: sortParams) {
//			String property = sortParam.getProperty();
//			boolean acending  = sortParam.isAccending();
//			if(property !=null) {
//				sql+= property;
//			}
//			if(!acending) {
//				sql+= "DESC";
//			}
//			sql += ",";
//		}
		return session.createNativeQuery("SELECT * FROM customer" + sortOrder.getSqlOrder(), Customer.class).getResultList();
	}
}
