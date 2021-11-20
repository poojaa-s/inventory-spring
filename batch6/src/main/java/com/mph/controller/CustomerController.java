package com.mph.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Customer;
import com.mph.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "http://localhost:4200",
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},
allowCredentials = "false",allowedHeaders = "*")

public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	private static final Logger logger = Logger.getLogger("CustomerController.class");
	
	@GetMapping("/allcus")
	public ResponseEntity<List<Customer>> allCustomer()
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST CUSTOMER");
		System.out.println(logger.getName()+  "   " + logger.getLevel());
		
		PropertyConfigurator.configure(CustomerController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull");
		List<Customer> clist=customerService.getCustomerList();
		System.out.println(clist);
		if(clist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(clist,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int cid)
	{
		Customer cus= customerService.getCustomerById(cid);
		if(cus == null)
		{
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer)
	{
		System.out.println("Update Rest () " + customer);
		List<Customer> uclist=customerService.updateCustomer(customer);
		System.out.println(uclist);
		if(uclist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(uclist,HttpStatus.OK);
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") int cid)
	{
		List<Customer> dulist=customerService.deleteCustomer(cid);
		System.out.println(dulist);
		if(dulist.isEmpty())
		{
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(dulist,HttpStatus.OK);
	}
}