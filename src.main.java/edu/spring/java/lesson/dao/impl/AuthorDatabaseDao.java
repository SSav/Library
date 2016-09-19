package edu.spring.java.lesson.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.AuthorDao;
import edu.spring.java.lesson.models.Author;

@Repository(value = "authorDatabaseDao")
public class AuthorDatabaseDao extends HibernateAbstractDao<Author> implements AuthorDao {

	public AuthorDatabaseDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Author> getAuthorsBySearch(String query) {
		List<Author> authors = null;
		Criteria criteria = getSession().createCriteria(Author.class);
		criteria.add(Restrictions.like("name", "%" + query + "%"));
		authors = criteria.list();
		for (Author author : authors) {
			System.err.println("...........Author....." + author.getName() + "..............");
		}

		return authors;

	}
}
