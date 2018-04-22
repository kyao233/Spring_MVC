package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();
	
	public Product getProductById(String productId);
	
	public List<Product> getProductByCategory(String category);
	
	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams);
	
	public Set<Product> getProductByPriceFilter(Map<String, List<String>> filterParams);
	
	public List<Product> getProductByManufacturer(String manufacturer);
		
	public void addProduct(Product product);
}
