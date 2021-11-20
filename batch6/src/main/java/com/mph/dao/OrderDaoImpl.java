package com.mph.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.mph.entity.Orders;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Orders> getOrdersList() {

		Query qry = getSession().createQuery("from Orders");
		List<Orders> orderList = qry.list();
		return orderList;

	}
	@Override
	public Orders getOrders(Orders orders) {
		Criteria c = getSession().createCriteria(Orders.class);
		//c.add(Restrictions.eq("email", supplier.getEmail()));
		Orders order1= (Orders)c.uniqueResult();
		
		return order1;
	}



	@Override
	public Orders getOrderById(int oid) {
		Query query = getSession().createQuery("from Orders order1 where oid=:oid");
		query.setParameter("oid", oid);
		Orders orders = (Orders)query.uniqueResult();;
		System.out.println(orders);
		return orders;
	}


	@Override
	public void CreateOrders(Orders orders) {
		getSession().saveOrUpdate(orders);
		System.out.println("Orders Stored Successfully :)");
	System.out.println("Orders->"+orders);
		
	}

	@Override
	public List<Orders> updateOrders(Orders orders) {
		Query qry = getSession().createQuery("update Orders set total=:Total,orderType=:ordertype where oid=:oid");
		qry.setParameter("Total",orders.getTotal());
		qry.setParameter("ordertype",orders.getOrderType() );
		qry.setParameter("oid", orders.getOid());
		
		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Update is successful !!!");
		}
		return getOrdersList();
	}
	@Override
	public List<Orders> deleteOrders(int oid) {
		Query qry = getSession().createQuery("delete orders where oid=:oid");		
		qry.setParameter("oid",oid );		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + oid + "successfully !!!");
		}
		return getOrdersList();
	}

}
