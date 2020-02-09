package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.ProductDAO;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;

	public ProductServiceImpl() {

		try {
			productDAO = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

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

}
