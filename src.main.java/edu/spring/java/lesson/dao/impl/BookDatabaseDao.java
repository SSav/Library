package edu.spring.java.lesson.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.BookDao;
import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.models.Genre;

@Repository(value = "bookDatabaseDao")
public class BookDatabaseDao extends HibernateAbstractDao<Book> implements BookDao {

	public BookDatabaseDao() {
		super();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Book> getBooksByGenre(Genre genre) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("genre", genre));
		List<Book> books = criteria.list();
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> getBooksByLetter(String str) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.like("title", str + "%"));
		List<Book> books = criteria.list();
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> getBooksBySearch(String query) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.like("title", "%" + query + "%"));
		List<Book> books = criteria.list();
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> getBooksByAuthorSearch(String query) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.like("author.name", "%" + query + "%"));
		List<Book> books = criteria.list();
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> getBooksByAuthor(Author author) {
		Criteria criteria = getSession().createCriteria(Book.class);
		criteria.add(Restrictions.eq("author", author));
		List<Book> books = criteria.list();
		return books;
	}
}
