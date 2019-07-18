package com.sapient.productservice.dao;

import java.util.ArrayList;
import java.util.List;

import com.sapient.productservice.model.Product;


public class ProductsDAOImpl implements ProductsDAO{

	private static List<Product> products = new ArrayList<Product>();

	public Product save(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
		return null;
	}

	
	public List<Product> listAll() {
		System.out.println("Inside the list all method of ProductsDAOimpl");
		return null;
	}

	public Product findById(int id) {
		System.out.println("Inside the findbyid method of ProductsDAOimpl");
		return null;
	}

	public void deleteProduct(int id) {
		System.out.println("inside the delete method of ProductsDAOimpl");
		
	}

}
