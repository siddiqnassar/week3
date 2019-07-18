package com.sapient.productservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository("hibernateDAOImpl")

public class HibernateProductDAOImpl implements ProductsDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Product save(Product product) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        return product;
	}

	@Override
	public List<Product> listAll() {
		 Session currentSession = sessionFactory.getCurrentSession();
	        return currentSession.createQuery("from Product").list();
		
	}

	@Override
	public Product findById(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
        Product product = session.byId(Product.class).load(id);
        session.delete(product);
		
	}

	
}
