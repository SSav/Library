package edu.spring.java.lesson.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.models.Genre;
import edu.spring.java.lesson.resources.R;
import edu.spring.java.lesson.services.AuthorService;
import edu.spring.java.lesson.services.BookService;
import edu.spring.java.lesson.services.GenreService;

@Controller
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value = "bookService")
	private BookService bookService;

	@Autowired
	@Qualifier(value = "genreService")
	private GenreService genreService;

	@Autowired
	@Qualifier(value = "authorService")
	private AuthorService authorService;

	public BookController() {

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookList() throws SQLException {
		ModelAndView modelAndView = new ModelAndView();

		List<Book> books = bookService.getBooks();
		List<Genre> genres = genreService.getGenres();
		List<String> russianLetters = R.Letters.russianLetters;

		modelAndView.addObject("russianLetters", russianLetters);
		modelAndView.addObject("genres", genres);
		modelAndView.addObject("books", books);
		modelAndView.setViewName("books");
		return modelAndView;

	}

	@RequestMapping(value = "/books-by-genre", method = RequestMethod.GET)
	public ModelAndView bookListByGenre(@RequestParam("genre_id") long id, Model model) throws SQLException {

		Genre genre = genreService.getGenreById(id);
		List<Genre> genres = genreService.getGenres();

		ModelAndView modelAndView = new ModelAndView();

		List<Book> books = bookService.getBooksByGenre(genre);
		List<String> russianLetters = R.Letters.russianLetters;

		modelAndView.addObject("russianLetters", russianLetters);

		modelAndView.addObject("books", books);
		modelAndView.addObject("genre", genre);
		modelAndView.addObject("genres", genres);
		modelAndView.setViewName("books");
		return modelAndView;

	}

	@RequestMapping(value = "/books-by-letter", method = RequestMethod.GET)
	public ModelAndView bookListByLetter(@RequestParam("letter") String str, Model model) throws SQLException {

		ModelAndView modelAndView = new ModelAndView();

		List<Book> books = bookService.getBooksByLetter(str);
		List<Genre> genres = genreService.getGenres();
		List<String> russianLetters = R.Letters.russianLetters;

		modelAndView.addObject("russianLetters", russianLetters);
		modelAndView.addObject("genres", genres);
		modelAndView.addObject("books", books);
		modelAndView.setViewName("books");
		return modelAndView;

	}

	@RequestMapping(value = "/books-by-search", method = RequestMethod.GET)
	public ModelAndView bookListBySearch(@RequestParam("search_string") String query,
			@RequestParam("search_option") String type, Model model) throws SQLException {

		ModelAndView modelAndView = new ModelAndView();
		List<Book> books = new ArrayList<>();
		if (type.equals("Название")) {
			books = bookService.getBooksBySearch(query);
		} else {
			List<Author> authors = authorService.getAuthorsBySearch(query);
			for (Author author : authors) {
				List<Book> b = bookService.getBooksByAuthor(author);
				books.addAll(b);
			}
		}
		List<String> russianLetters = R.Letters.russianLetters;
		List<Genre> genres = genreService.getGenres();

		modelAndView.addObject("russianLetters", russianLetters);
		modelAndView.addObject("books", books);
		modelAndView.addObject("genres", genres);
		modelAndView.setViewName("books");
		return modelAndView;

	}

	@RequestMapping(value = "/ShowImage", method = RequestMethod.GET)
	protected void processRequestImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		try {
			int index = Integer.valueOf(request.getParameter("index"));
			System.err.println("------------------index-----------" + index);

			Book book = bookService.getBookById(index);

			System.err.println("---------------title-----------" + book.getTitle());
			response.setContentLength(book.getImage().length);
			out.write(book.getImage());
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "/Content", method = RequestMethod.GET)
	protected void processRequestContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		try {
			int index = Integer.valueOf(request.getParameter("index"));
			System.err.println("------------------index content-----------" + index);

			HashMap sessionMap = (HashMap) getServletContext().getAttribute("sessionMap");

			HttpSession session = (HttpSession) sessionMap.get(request.getParameter("session_id"));

			Book book = bookService.getBookById(index);
			System.err.println("---------------title-----------" + book.getTitle());
			response.setContentLength(book.getContent().length);
			out.write(book.getContent());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String add(@RequestBody Book book) throws SQLException {
		System.out.println(book.toString());
		System.err.println(".................................");
		bookService.save(book);
		return "OK";

	}

}
