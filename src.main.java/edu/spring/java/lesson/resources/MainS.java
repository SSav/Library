package edu.spring.java.lesson.resources;

import java.util.List;

import edu.spring.java.lesson.models.Author;

public class MainS {
	private static Author author;

	@SuppressWarnings("null")
	public static void main(String[] args) {
		List<Author> authors = null;
		if (authors.size() == 0) {
			author = null;
		} else {
			author = authors.get(0);
		}
		System.out.println("[0]= " + author);
	}
}