package com.Pooja.springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Pooja.springDemo.dao.CustomerDao;
import com.Pooja.springDemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {

		 customerDao.saveCustomer(theCustomer);
	}

	@Transactional
	public Customer updateCustomer(int id) {

		return customerDao.updateCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {
		
		customerDao.deleteCustomer(id);
	}

}
