package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.ParentProductCategoryDao;
import edu.spring.java.lesson.models.ParentProductCategory;

@Repository(value = "parentProductCategoryDatabaseDao")
public class ParentProductCategoryDatabaseDao extends HibernateAbstractDao<ParentProductCategory>
		implements ParentProductCategoryDao {

	public ParentProductCategoryDatabaseDao() {
		super();
	}

}
