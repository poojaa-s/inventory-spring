package com.mph.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="ORDERTABLE")

public class Orders implements Serializable {
	//@Id
	//@SequenceGenerator(name = "ORDER_SEQ",sequenceName = "order_seq",
	//initialValue = 1, allocationSize = 100)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	
	@Column	
	private double total;
	@Column	
	private String orderType;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="MM/dd/yyyy")
	@Column	
	private Date orderDate;
	

@OneToOne
@JoinColumn(name="cid")
private Customer customer;
	
	
	public Orders() {
		super();
    }

    public Orders(int oid, Customer customer, double total, String orderType, Date orderDate) {
        super();
    	this.oid = oid;
        this.customer = customer;
        this.total = total;
        this.orderType = orderType;
        this.orderDate = orderDate;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

   

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
    	return customer;
    }


    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", total=" + total + ", orderType=" + orderType + ", orderDate=" + orderDate
				+ ", customer=" + customer + "]";
	}



}

	
	
	
	
	


