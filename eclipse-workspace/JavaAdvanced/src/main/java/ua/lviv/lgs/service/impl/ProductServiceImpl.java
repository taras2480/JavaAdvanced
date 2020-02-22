package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDAO;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	private static ProductServiceImpl productServiceImpl;

	private ProductServiceImpl() {

		try {
			productDAO = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			LOGGER.error(e);
		}

	}

	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}

		return productServiceImpl;

	}

	@Override
	public Product create(Product t) {

		return productDAO.create(t);
	}

	@Override
	public Product read(Integer id) {

		return productDAO.read(id);
	}

	@Override
	public Product update(Product t) {

		return productDAO.update(t);
	}

	@Override
	public void delete(Integer id) {
		productDAO.delete(id);

	}

	@Override
	public List<Product> readAll() {

		return productDAO.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {

		return readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));

	}

}
