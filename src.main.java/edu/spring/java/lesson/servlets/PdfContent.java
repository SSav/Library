/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spring.java.lesson.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.spring.java.lesson.models.Book;
import edu.spring.java.lesson.services.BookService;

@WebServlet(name = "pdfContent", urlPatterns = "/PdfContent")
public class PdfContent extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier(value = "bookService")
	private BookService bookService;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
