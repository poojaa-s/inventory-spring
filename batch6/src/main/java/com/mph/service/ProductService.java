package com.mph.service;

import java.util.List;

import com.mph.entity.Product;

public interface ProductService {
	public List<Product> getProductList();
	public Product getProduct(Product product);
	public void createProduct(Product product);
	public List<Product> updateProduct(Product product);
	public List<Product> deleteProduct(int pid);
	public Product getProductById(int pid);
	public Product getProductByName(String pname);
}