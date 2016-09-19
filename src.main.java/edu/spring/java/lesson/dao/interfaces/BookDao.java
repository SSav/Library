package edu.spring.java.lesson.dao.interfaces;

import java.util.List;

import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.models.Genre;

public interface BookDao extends ItemDao<Book> {

	List<Book> getBooksByGenre(Genre genre);

	List<Book> getBooksByLetter(String str);

	List<Book> getBooksBySearch(String query);

	List<Book> getBooksByAuthorSearch(String query);

	List<Book> getBooksByAuthor(Author author);

}
