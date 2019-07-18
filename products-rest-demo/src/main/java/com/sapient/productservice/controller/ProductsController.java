package com.sapient.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;
import com.sapient.productservice.service.ProductServiceImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

	@Autowired (required= true)
	@Qualifier(value="productService")
	
	private ProductService productService;
	@GetMapping(value="/",produces = {APPLICATION_JSON_VALUE ,APPLICATION_XML_VALUE})
	public List<Product> listAll()
	{
		List<Product> product=new ArrayList();
    	product = productService.fetchAllProducts();
    	
        //model.addAttribute("empList", empList);
        return product;
		//List<Product> products=Arrays.asList(new Product(1,"cake",(double)60),new Product(2,"carrot",(double)10),new Product(4,"chilly",(double)30));

	}
	@GetMapping(value = "/{id}",produces= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public Product findById(@PathVariable("id") int id)
	{
		Product product=new Product(123,"fauzia",34);
		product=productService.findById(id);
    	//employee = employeeService.fetchAllEmployees();
    	
        //model.addAttribute("empList", empList);
        return product;
		
	}
	
	@PostMapping(value="/save",consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public Product saveProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return product;
	}
	/*@PutMapping(value="/update",consumes={APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable("id") int id)
	{
		
		System.out.println("came inside update product");
	}

	*/
	@DeleteMapping(value="/delete/{id}", consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public void deleteProduct(@PathVariable("id") int id)
	{
		productService.deleteProducts(id);
		System.out.println("came inside delete product");
	}
}
