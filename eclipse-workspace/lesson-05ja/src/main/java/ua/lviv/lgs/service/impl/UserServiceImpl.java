package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.UserDAO;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO usertDAO;

	public UserServiceImpl() {

		try {
			usertDAO = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public User create(User t) {

		return usertDAO.create(t);
	}

	@Override
	public User read(Integer id) {

		return usertDAO.read(id);
	}

	@Override
	public User update(User t) {

		return usertDAO.update(t);
	}

	@Override
	public void delete(Integer id) {
		usertDAO.delete(id);

	}

	@Override
	public List<User> readAll() {

		return usertDAO.readAll();
	}

}
