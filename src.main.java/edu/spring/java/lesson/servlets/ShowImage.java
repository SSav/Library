
package edu.spring.java.lesson.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.services.BookService;

public class ShowImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier(value = "bookService")
	private BookService bookService;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		try {
			int index = Integer.valueOf(request.getParameter("index"));
			System.err.println("............index image.........." + index);
			Book book = bookService.getBookById(index);
			System.err.println("............Book title.........." + book.getTitle());

			response.setContentLength(book.getImage().length);
			out.write(book.getImage());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
