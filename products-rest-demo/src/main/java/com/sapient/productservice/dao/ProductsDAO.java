package com.sapient.productservice.dao;

import java.util.List;

import com.sapient.productservice.model.Product;



public interface ProductsDAO {

	public Product save(Product product);

    public List<Product> listAll();

    public Product findById(int id);

    public void deleteProduct(int id);

}
