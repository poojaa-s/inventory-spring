package com.mph.dao;

import java.util.List;
import com.mph.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomerList();
	public Customer getCustomer(Customer customer);
	public void saveCustomer(Customer customer);
	public List<Customer> updateCustomer(Customer customer);
	public List<Customer> deleteCustomer(int cid);
	public List<Customer> searchCustomerById(int cid);
	public Customer getCustomerById(int cid);
}