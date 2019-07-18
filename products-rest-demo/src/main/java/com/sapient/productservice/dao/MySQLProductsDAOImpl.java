package com.sapient.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;




@Repository(value = "mysqlDAOImpl")
public class MySQLProductsDAOImpl implements ProductsDAO{

	  @Autowired
	    private JdbcTemplate jdbcTemplate;
	  public MySQLProductsDAOImpl(JdbcTemplate jdbcTemplate){
	        this.jdbcTemplate = jdbcTemplate;
	    }
	  public Product save(Product product) {
	        System.out.println("Came inside the save method of MySQLproductDAOImpl");
	        jdbcTemplate.execute("insert into product(id,name1,price) values ('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"')");
	        return product;
	    }

	    public Product findById(int id) {
	    	List<Product> productList = jdbcTemplate.query("select * from product where id="+id,
	                ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2),rs.getInt(3)));
	    	 for(Product product: productList)
	         {
	    		 if(product.getId()==id)
	    		 {
	    			 Product e=product;
	    			
	    			 return e;
	    		 }
	         	
	         }
	    	 return null;
	    }
		
		public List<Product> listAll() {
			List<Product> productList = jdbcTemplate.query("select * from product",
	                ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2),rs.getInt(3)));
	    	 for(Product product:productList)
	         {
	         	System.out.println(product.getName());
	         }
	        return productList;
			
		}
		
		public void deleteProduct(int id) {
			// TODO Auto-generated method stub
			jdbcTemplate.execute("delete from product where id='"+id+"'");
			System.out.println("deleted the id from database");
			
		}
}
