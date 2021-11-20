package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Customer;


@Repository
public class  CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public List<Customer> getCustomerList() {
		Query qry = getSession().createQuery("from Customer");
		List<Customer> Cuslist = qry.list();
		return Cuslist;
	}

	public Customer getCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Customer.class);
		//c.add(Restrictions.eq("cid", customer.getCid()));
		Customer cus =(Customer)c.uniqueResult();
		return cus;
	}

	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(customer);
		System.out.println("customer Stored Successfully :)");
		
	}


	public List<Customer> updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Query qry = getSession().createQuery("update Customer set cname=:name,phone=:Phone where cid=:cno");
		qry.setParameter("name", customer.getCname());
		qry.setParameter("Phone",customer.getPhone());
		qry.setParameter("cno", customer.getCid());
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getCustomerList();
	}

	public List<Customer> deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		Query qry = getSession().createQuery("delete Customer where cid=:cno");		
		qry.setParameter("cno", cid);		
				
		int noofrows = qry.executeUpdate();
				if(noofrows >0)
				{
					System.out.println("Deleted " + cid + "successfully !!!");
				}
				return getCustomerList();
	}

	public List<Customer> searchCustomerById(int cid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Customer cus where cid=:cno");
		query.setParameter("cno", cid);
		List<Customer> cuslist =query.list();
		System.out.println(cuslist);
		return cuslist; 
	}

	public Customer getCustomerById(int cid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Customer cus where cid=:cno");
		query.setParameter("cno", cid);
		Customer cuslist =(Customer) query.uniqueResult();
		System.out.println(cuslist);
		return cuslist; 
	}

	
}