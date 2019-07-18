package com.sapient.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductsDAO;
import com.sapient.productservice.model.Product;


@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

	 @Autowired( required = true)
	    @Qualifier(value = "hibernateDAOImpl")
	    private ProductsDAO productsDao;

	    public ProductServiceImpl(@Qualifier(value = "mysqlDAOImpl")ProductsDAO productsDao){
	        this.productsDao=productsDao;
	    }

	    @Transactional
	    public Product saveProduct(Product product) {
	        System.out.println("Inside the save employee method of Employee service class ....");
	        return productsDao.save(product);
	    }

	    @Transactional
	    public List<Product> fetchAllProducts() {
	        return productsDao.listAll();
	    }

	    @Transactional
	    public Product findById(int id) {
	        return productsDao.findById(id);
	    }

	    @Transactional
	    public void deleteProducts(int id) {

	    	productsDao.deleteProduct(id);
	    }


		
	
}
