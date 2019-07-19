package com.sapient.productservice.service;

import java.util.List;

import com.sapient.productservice.model.Product;


public interface ProductService {

	 public Product saveProduct(Product product);

	    public List<Product> fetchAllProducts();

	    public Product findById(int id);

	    public void deleteProducts(int id);
	    public Product updateProduct(int id,Product product);
}
