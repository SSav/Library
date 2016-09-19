package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.OrderDao;
import edu.spring.java.lesson.models.Order;

@Repository(value = "orderDatabaseDao")
public class OrderDatabaseDao extends HibernateAbstractDao<Order> implements OrderDao {

	public OrderDatabaseDao() {
		super();
	}

}
