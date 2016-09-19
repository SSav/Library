package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.UserRoleDao;
import edu.spring.java.lesson.models.UserRole;

@Repository(value = "roleDatabaseDao")
public class RoleDatabaseDao extends HibernateAbstractDao<UserRole> implements UserRoleDao {

	public RoleDatabaseDao() {
		super();
	}

}
