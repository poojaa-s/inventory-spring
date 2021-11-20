package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Product;
import com.mph.dao.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDao.getProductList();
	}

	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.getProduct(product);
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.createProduct(product);
	}

	@Override
	public List<Product> updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public List<Product> deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(pid);
	}

	@Override
	public Product getProductById(int pid) {
		// TODO Auto-generated method stub
		return productDao.getProductById(pid);
	}

	@Override
	public Product getProductByName(String pname) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(pname);
	}
	
	

}