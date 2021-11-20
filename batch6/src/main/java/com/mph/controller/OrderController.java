package com.mph.controller;

import java.util.List;

import org.hibernate.Query;
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

import com.mph.entity.Orders;



import com.mph.service.OrderService;
@RestController
@RequestMapping(value="/orders")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/allorders")
	public ResponseEntity<List<Orders>> allorders(){
	
		List<Orders> orderList=orderService.getOrdersList();
		System.out.println(orderList);
		if(orderList.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(orderList,HttpStatus.OK);
	}
	
	@GetMapping("/orderById/{oid}")
	public ResponseEntity<Orders> orderById(@PathVariable("oid") int oid){
		Orders orders=orderService.getOrderById(oid);
		
		return new ResponseEntity<Orders>(orders,HttpStatus.OK);
	}	

	@PostMapping("/CreateOrder")
	public Orders CreateOrders(@RequestBody Orders orders) {
		orderService.CreateOrders(orders);
		return orders;
	}
	
	/*@PutMapping("/updateOrder/{oid}")
	public ResponseEntity<?> updateOrders(@RequestBody Orders orders){
		orderService.updateOrders(orders);
		
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}*/

	@PutMapping("/updateOrder")
    public ResponseEntity<List<Orders>> updateOrders(@RequestBody Orders orders)
    {
        System.out.println("Update Rest () " + orders);
        List<Orders> uolist=orderService.updateOrders(orders);
        System.out.println(uolist);
        if(uolist.isEmpty())
        {
            return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orders>>(uolist,HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteOrder/{oid}")
	public ResponseEntity<List<Orders>> deleteOrders(@PathVariable("oid") int oid)
	{
		List<Orders> dolist=orderService.deleteOrders(oid);
		System.out.println(dolist);
		if(dolist.isEmpty())
		{
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(dolist,HttpStatus.OK);
	}
	
}

