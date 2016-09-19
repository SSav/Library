package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.ProductCategoryDao;
import edu.spring.java.lesson.models.ProductCategory;

@Repository(value = "productCategoryDatabaseDao")
public class ProductCategoryDatabaseDao extends HibernateAbstractDao<ProductCategory> implements ProductCategoryDao {

	public ProductCategoryDatabaseDao() {
		super();
	}

}
