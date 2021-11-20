package com.mph.dao;

import java.util.List;

import com.mph.entity.Product;

public interface ProductDao {
	public List<Product> getProductList();
	public Product getProduct(Product product);
	public void createProduct(Product product);
	public List<Product> updateProduct(Product product);
	public List<Product> deleteProduct(int pid);
	public Product getProductById(int pid);
	public Product getProductByName(String pname);
}