package com.mph.entity;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="PRODUCTS")
public class Product {
	@Id
	@SequenceGenerator(name = "ORDER_SEQ",sequenceName = "order_seq",
			initialValue = 1, allocationSize = 100)
	private int pid;
	@Column
	private String pname;
	@Column
	private double price;
	@Column
	private int qty;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="MM/dd/yyyy")
	private Date mdate;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="MM/dd/yyyy")
	private Date edate;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int pid, String pname, double price, int qty, Date mdate, Date edate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
		this.mdate = mdate;
		this.edate = edate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", mdate=" + mdate
				+ ", edate=" + edate + "]";
	}
	
	
}