package com.mph.controller;

import java.util.List;

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


import com.mph.entity.Product;
import com.mph.service.ProductService;

@RestController
@RequestMapping(value="/product")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value="/allproducts")
	public ResponseEntity<List<Product>> allProduct(){
		
		
		List<Product> plist=productService.getProductList();
		System.out.println(plist);
		if(plist.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(plist,HttpStatus.OK);
	}
	
	@PostMapping("/createproduct")
	public Product createProduct(@RequestBody Product product ) {
		productService.createProduct(product);
		return product;
	}
	
	@PutMapping("/updateproduct")
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		productService.updateProduct(product);
		return new ResponseEntity<String>(" Medicine updated sucessfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteproduct/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int pid){
		productService.deleteProduct(pid);
		return new ResponseEntity<String>("Medicine deleted sucessfully",HttpStatus.OK);
	}
	
	@GetMapping("/productById/{pid}")
	public ResponseEntity<Product> productById(@PathVariable("pid") int pid){
		Product product=productService.getProductById(pid);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/productByName/{pname}")
	public ResponseEntity<Product> productByName(@PathVariable("pname") String pname){
		Product product=productService.getProductByName(pname);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}	
}