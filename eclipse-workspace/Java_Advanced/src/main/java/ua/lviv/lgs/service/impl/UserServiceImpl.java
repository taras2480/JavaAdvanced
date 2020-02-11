package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.UserDAO;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	private static Logger LOGGER = Logger.getLogger(AdressServiceImpl.class);
	private static UserServiceImpl userServiceImpl;

	private UserServiceImpl() {

		try {
			userDAO = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			LOGGER.error(e);
		}

	}

	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}

		return userServiceImpl;

	}

	@Override
	public User create(User t) {

		return userDAO.create(t);
	}

	@Override
	public User read(Integer id) {

		return userDAO.read(id);
	}

	@Override
	public User update(User t) {

		return userDAO.update(t);
	}

	@Override
	public void delete(Integer id) {
		userDAO.delete(id);

	}

	@Override
	public List<User> readAll() {

		return userDAO.readAll();
	}

	@Override
	public User getUserFromEmail(String email) {
		
		return userDAO.getUserFromEmail(email);
	}

}
