package com.mph.service;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.OrderDao;

import com.mph.entity.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	@Override
	public List<Orders> getOrdersList(){
		 return	orderDao.getOrdersList();
		
	}
	@Override
	public Orders getOrderById(int oid) {
		return orderDao.getOrderById(oid);
	}
	@Override
	public void CreateOrders(Orders orders) {
		orderDao.CreateOrders(orders);
	}
	@Override
	public List<Orders> updateOrders(Orders orders){
		return orderDao.updateOrders(orders);
	}
	@Override
	public List<Orders> deleteOrders(int oid){
		return orderDao.deleteOrders(oid);
	}
	@Override
	public Orders getOrders(Orders orders) {
		// TODO Auto-generated method stub
		return orderDao.getOrders(orders);
	}

}
