package edu.spring.java.lesson.dao.impl;

import org.springframework.stereotype.Repository;

import edu.spring.java.lesson.dao.interfaces.GenreDao;
import edu.spring.java.lesson.models.Genre;

@Repository(value = "genreDatabaseDao")
public class GenreDatabaseDao extends HibernateAbstractDao<Genre> implements GenreDao {
	public GenreDatabaseDao() {
		super();
	}

}
