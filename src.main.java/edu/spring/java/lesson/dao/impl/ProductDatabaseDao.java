package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.ProductDao;
import edu.spring.java.lesson.models.Product;

@Repository(value = "productDatabaseDao")
public class ProductDatabaseDao extends HibernateAbstractDao<Product> implements ProductDao {

	public ProductDatabaseDao() {
		super();
	}

}
