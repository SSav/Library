package edu.spring.java.lesson.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.java.lesson.dao.interfaces.ProductDao;
import edu.spring.java.lesson.models.Product;
import edu.spring.java.lesson.resources.LogConfig;
import edu.spring.java.lesson.resources.R;

@Service(value = "productService")
public class ProductService {

	private static Logger logger = Logger.getLogger(ProductService.class);
	private static String LOG_PROPERTIES_FILE = R.Log.LOG_PROPERTIES_FILE;

	@Autowired
	@Qualifier("productDatabaseDao")
	private ProductDao productDao;

	public ProductService() {

	}

	@Transactional
	public List<Product> getProducts() throws SQLException {
		List<Product> products = new ArrayList<>();
		products = productDao.getAll();
		new LogConfig(LOG_PROPERTIES_FILE);
		for (Product product : products) {
			logger.warn("Product #" + product.toString());
		}

		return products;

	}

}
