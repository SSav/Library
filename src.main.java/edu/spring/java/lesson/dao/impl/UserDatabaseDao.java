package edu.spring.java.lesson.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.UserDao;
import edu.spring.java.lesson.models.User;

@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

	public UserDatabaseDao() {
		super();
	}

	@Override
	@Transactional
	public User getByUsername(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));

		return (User) criteria.uniqueResult();
	}

}
