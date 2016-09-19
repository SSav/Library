package edu.spring.java.lesson.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.BookDao;
import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.models.Genre;
import edu.spring.java.lesson.resources.LogConfig;
import edu.spring.java.lesson.resources.R;

@Service(value = "bookService")
public class BookService {
	private static String LOG_PROPERTIES_FILE = R.Log.LOG_PROPERTIES_FILE;
	private static Logger logger = Logger.getLogger(BookService.class);

	@Autowired
	@Qualifier(value = "bookDatabaseDao")
	private BookDao bookDao;

	public BookService() {
	}

	@Transactional
	public List<Book> getBooks() throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Book> books = bookDao.getAll();
		for (Book book : books) {
			logger.warn("Book #" + book);
		}
		return books;
	}

	@Transactional
	public List<Book> getBooksByGenre(Genre genre) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Book> books = bookDao.getBooksByGenre(genre);
		for (Book book : books) {
			logger.warn("Book #" + book);
		}
		return books;
	}

	@Transactional
	public List<Book> getBooksByLetter(String letter) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Book> books = bookDao.getBooksByLetter(letter);
		for (Book book : books) {
			logger.warn("Book #" + book);
		}
		return books;

	}

	@Transactional
	public List<Book> getBooksBySearch(String query) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Book> books = bookDao.getBooksBySearch(query);
		for (Book book : books) {
			logger.warn("Book #" + book);
		}
		return books;
	}

	@Transactional
	public List<Book> getBooksByAuthor(Author author) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Book> books = bookDao.getBooksByAuthor(author);
		for (Book book : books) {
			logger.warn("Book #" + book);
		}
		return books;
	}

	@Transactional
	public Book getBookById(long id) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		Book book = bookDao.getById(id);
		logger.warn("Book #" + book);

		return book;
	}

	@Transactional
	public void save(Book book) throws SQLException {
		bookDao.add(book);
	}

}
