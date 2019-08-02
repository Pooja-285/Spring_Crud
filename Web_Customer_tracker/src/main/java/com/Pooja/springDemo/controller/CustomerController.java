package com.Pooja.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Pooja.springDemo.entity.Customer;
import com.Pooja.springDemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//INJECT THE CUSTOMER SERVICE..Spring will scan for a component that implements this interface
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String customerlist(Model theModel)
	{
//		GET CUSTOMERS FROM SERVICE
		List<Customer> customers = customerService.getCustomers();
		
//		ADD THE CUSTOMERS TO THE MODEL
		theModel.addAttribute("theCustomer",customers);

		return "list_customers";
	}
	
	
	@GetMapping("/add")
	public String addCustomer(Model theModel)
	{
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("theCustomer", theCustomer);
		
		return "addCustomer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("theCustomer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		
		return "saveCustomer";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int id,Model theModel)
	{
		Customer theCustomer = customerService.updateCustomer(id);
		
		// the value should be same as in the addCustomer.jsp
		theModel.addAttribute("theCustomer",theCustomer);
		
		return "addCustomer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
}
