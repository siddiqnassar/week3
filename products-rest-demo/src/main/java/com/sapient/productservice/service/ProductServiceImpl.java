package com.sapient.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductsDAO;
import com.sapient.productservice.model.Product;
import com.sapient.productservice.repository.ProductRepository;


@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

	 @Autowired( required = true)
	    @Qualifier(value = "hibernateDAOImpl")
	    private ProductsDAO productsDao;

	 @Autowired
	 private ProductRepository productRepository;
	 
//	    public ProductServiceImpl(@Qualifier(value = "mysqlDAOImpl")ProductsDAO productsDao){
//	        this.productsDao=productsDao;
//	    }

	 public ProductServiceImpl(ProductRepository productRepository)
	 {
		 this.productRepository=productRepository;
	 }
	    @Transactional
	    public Product saveProduct(Product product) {
	        System.out.println("Inside the save employee method of Employee service class ....");
	        return productRepository.save(product);
	    }

	    @Transactional
	    public List<Product> fetchAllProducts() {
	        return (List<Product>) productRepository.findAll();
	    }

	    @Transactional
	    public Product findById(int id) {
	    	Optional<Product> optionalProduct =productRepository.findById( id); 
	        if(optionalProduct.isPresent())
	        {
	        	return optionalProduct.get();
	        }
	        throw new IllegalArgumentException("Product not found");
	        
	    }

	    @Transactional
	    public void deleteProducts(int id) {
	    	productRepository.deleteById(id);
	    }
	    
	    public Product updateProduct(int id,Product product)
	    {
	    	Optional<Product> optionalProduct = productRepository.findById(id);
	    	if(optionalProduct.isPresent())
	    	{
	    		Product currentProduct=optionalProduct.get();
	    		currentProduct.setName(product.getName());
	    		currentProduct.setPrice(product.getPrice());
	    		//currentProduct.setDependants(product.getDependants());
	    		//currentProduct.setProductDetails(product.getProductDetails());
	    		productRepository.save(currentProduct);
	    	}
	    	return optionalProduct.get();
	    }


		
	
}
