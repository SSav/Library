package edu.spring.java.lesson.dao.interfaces;

import java.util.List;

import edu.spring.java.lesson.models.Author;

public interface AuthorDao extends ItemDao<Author> {

	List<Author> getAuthorsBySearch(String query);

}
