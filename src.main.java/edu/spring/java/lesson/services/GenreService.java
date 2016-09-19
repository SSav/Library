package edu.spring.java.lesson.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.GenreDao;
import edu.spring.java.lesson.models.Genre;
import edu.spring.java.lesson.resources.LogConfig;
import edu.spring.java.lesson.resources.R;

@Service(value = "genreService")
public class GenreService {

	private static String LOG_PROPERTIES_FILE = R.Log.LOG_PROPERTIES_FILE;
	private static Logger logger = Logger.getLogger(GenreService.class);

	@Autowired
	@Qualifier(value = "genreDatabaseDao")
	private GenreDao genreDao;

	public GenreService() {
	}

	@Transactional
	public List<Genre> getGenres() throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		List<Genre> genres = genreDao.getAll();
		for (Genre genre : genres) {
			logger.warn("Genre #" + genre);
		}
		return genres;
	}

	@Transactional
	public Genre getGenreById(long id) throws SQLException {
		new LogConfig(LOG_PROPERTIES_FILE);
		Genre genre = genreDao.getById(id);

		logger.warn("Genre #" + genre.getId() + " " + genre.getTitle());

		return genre;
	}
}
