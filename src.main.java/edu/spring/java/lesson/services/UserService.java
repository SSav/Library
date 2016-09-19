package edu.spring.java.lesson.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.UserDao;
import edu.spring.java.lesson.models.User;

@Service(value = "userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier(value = "userDatabaseDao")
	private UserDao userDao;

	public UserService() {

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.getByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username: " + username + "not found!");

		System.err.println("............" + username + " is " + user + "..............");

		return user;
	}

	@Transactional
	public List<User> getUsers() throws SQLException {
		return userDao.getAll();

	}

}
