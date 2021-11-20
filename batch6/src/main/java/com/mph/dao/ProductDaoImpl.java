package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		Query qry = getSession().createQuery("from Product");
		List<Product> productlist = qry.list();
		return productlist;
	}

	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Product.class);
		 Product products= (Product)c.uniqueResult();
		 return products;
		
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(product);
		System.out.println(product + "Medicine Stored Successfully :)");
	}

	@Override
	public List<Product> updateProduct(Product product) {
		// TODO Auto-generated method stub
		Query qry = getSession().createQuery("update Product set pname=:pname,price=:price,qty=:qty,mdate=:mdate,edate=:edate where pid=:pid");
		qry.setParameter("pid", product.getPid());
		qry.setParameter("pname", product.getPname());
		qry.setParameter("price", product.getPrice());
		qry.setParameter("qty", product.getQty());
		qry.setParameter("mdate", product.getMdate());
		qry.setParameter("edate", product.getEdate());
	
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println(" Medicine updated successfully !!!");
		}
		return getProductList();
	}

	@Override
	public List<Product> deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Query qry = getSession().createQuery("delete Product where pid=:pid");		
		qry.setParameter("pid", pid);		
		int noofrows = qry.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted medicine with  " + pid + " !!!");
		}
		return getProductList();
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		Product product = (Product)query.uniqueResult();;
		System.out.println(product);
		return product;
	}

	@Override
	public Product getProductByName(String pname) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Product book where  pname=:pname");
		query.setParameter("pname", pname);
		Product product = (Product)query.uniqueResult();
		System.out.println(product);
		return product;
	}

}