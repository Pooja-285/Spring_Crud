package com.Pooja.springDemo.service;

import java.util.List;

import com.Pooja.springDemo.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer updateCustomer(int id);

	public void deleteCustomer(int id);
}
