package edu.spring.java.lesson.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.spring.java.lesson.models.Genre;
import edu.spring.java.lesson.resources.R;
import edu.spring.java.lesson.services.GenreService;

@Controller
public class FirstPageController {

	@Autowired
	@Qualifier(value = "genreService")
	private GenreService genreService;

	public FirstPageController() {

	}

	@RequestMapping(value = "/first-page", method = RequestMethod.POST)
	public ModelAndView bookList() throws SQLException {
		ModelAndView modelAndView = new ModelAndView();

		List<Genre> genres = genreService.getGenres();
		List<String> russianLetters = R.Letters.russianLetters;

		modelAndView.addObject("russianLetters", russianLetters);
		modelAndView.addObject("genres", genres);
		modelAndView.setViewName("books");
		return modelAndView;
	}
}
