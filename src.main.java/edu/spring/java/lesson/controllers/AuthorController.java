package edu.spring.java.lesson.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.spring.java.lesson.models.Author;
import edu.spring.java.lesson.services.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	@Qualifier(value = "authorService")
	private AuthorService authorService;

	public AuthorController() {

	}

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public ModelAndView getAuthors() throws SQLException {
		ModelAndView modelAndView = new ModelAndView();

		List<Author> authors = authorService.getAuthors();
		modelAndView.addObject("authors", authors);
		modelAndView.setViewName("authors");

		return modelAndView;
	}
}
