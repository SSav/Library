package edu.spring.java.lesson.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.AuthorDao;
import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.resources.LogConfig;
import edu.spring.java.lesson.resources.R;

@Service(value = "authorService")
public class AuthorService {

	private static Logger logger = Logger.getLogger(AuthorService.class);
	private static String LOG_PROPERTIES_FILE = R.Log.LOG_PROPERTIES_FILE;

	@Autowired
	@Qualifier("authorDatabaseDao")
	private AuthorDao authorDao;

	public AuthorService() {

	}

	@Transactional
	public List<Author> getAuthors() throws SQLException {
		List<Author> authors = new ArrayList<>();
		authors = authorDao.getAll();
		new LogConfig(LOG_PROPERTIES_FILE);
		for (Author author : authors) {
			logger.warn("Author #" + author.toString());
		}
		return authors;
	}

	@Transactional
	public List<Author> getAuthorsBySearch(String query) throws SQLException {
		List<Author> authors = new ArrayList<>();
		authors = authorDao.getAuthorsBySearch(query);
		new LogConfig(LOG_PROPERTIES_FILE);
		for (Author author : authors) {
			logger.warn("Author #" + author.toString());
		}
		return authors;
	}

}
