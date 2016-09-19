package edu.spring.java.lesson.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.spring.java.lesson.models.Product;
import edu.spring.java.lesson.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	@Qualifier(value = "productService")
	private ProductService productService;

	public ProductController() {

	}

	@RequestMapping(value = "/list1", method = RequestMethod.GET)
	public ModelAndView productList() throws SQLException {
		ModelAndView modelAndView = new ModelAndView();

		List<Product> products = productService.getProducts();

		modelAndView.addObject("products", products);
		modelAndView.setViewName("products");
		return modelAndView;

	}
}
