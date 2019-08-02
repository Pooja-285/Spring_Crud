/*  We are using Dao class here to get the data from the database and send it to the JSP page */

package com.Pooja.springDemo.dao;

import java.util.List;
import com.Pooja.springDemo.entity.Customer;


public interface CustomerDao {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer updateCustomer(int id);

	public void deleteCustomer(int id);
}
