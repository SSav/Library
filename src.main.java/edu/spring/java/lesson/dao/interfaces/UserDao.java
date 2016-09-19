package edu.spring.java.lesson.dao.interfaces;

import edu.spring.java.lesson.models.User;

public interface UserDao extends ItemDao<User> {

	public User getByUsername(String username);

}
