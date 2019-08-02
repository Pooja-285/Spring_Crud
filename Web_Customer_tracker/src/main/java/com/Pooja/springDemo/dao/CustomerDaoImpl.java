/* For hibernate the DAO needs a session Factory and the session factory needs a data source.
 * Datasource defines the database connection info. it tells how to connect to the database.
 *  Since all of these are dependency so we are using Autowired.
 *  All these configs are done in spring-mvc-demo-servlet.xml 
 * */

package com.Pooja.springDemo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Pooja.springDemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

//	INJECT THE SESSION FACTORY
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Customer> getCustomers() {

//		GET THE CURRENT HIBERNATE SESSION
		Session session = sessionFactory.getCurrentSession();
		
//		CREATE A QUERY
		Query<Customer> theQuery = session.createQuery("from Customer",Customer.class);
		
//		EXECUTE QUERY & CREATE RESULT LIST
		List<Customer> customers = theQuery.getResultList();
		
//		RETURN THE RESULTS
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {

		Session session = sessionFactory.getCurrentSession();
		
		//This method can be used to add the data in the database.
//		If primary key is empty, insert new data else update the existing one
		session.saveOrUpdate(theCustomer);
	}

	public Customer updateCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Customer cust = session.get(Customer.class, id);
		
		return cust;
	}

	public void deleteCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Customer cust = session.get(Customer.class, id);
		
		session.delete(cust);
	}

}
