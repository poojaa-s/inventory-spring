package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;

	public List<Customer> getCustomerList() {
		return customerDao.getCustomerList();
	}

	public Customer getCustomer(Customer customer) {
		return customerDao.getCustomer(customer);
	}

	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	public List<Customer> updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	public List<Customer> deleteCustomer(int cid) {
		return customerDao.deleteCustomer(cid);
	}

	public List<Customer> searchCustomerById(int cid) {
		return customerDao.searchCustomerById(cid);
	}

	public Customer getCustomerById(int cid) {
		return customerDao.getCustomerById(cid);
	}
	
	
	
	
}