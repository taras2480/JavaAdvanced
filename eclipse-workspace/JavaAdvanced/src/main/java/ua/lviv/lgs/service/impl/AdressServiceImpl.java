package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.AdressDAO;
import ua.lviv.lgs.dao.impl.AdressDaoImpl;
import ua.lviv.lgs.domain.Adress;
import ua.lviv.lgs.service.AdressService;

public class AdressServiceImpl implements AdressService {

	private AdressDAO adressDAO;
	private static Logger LOGGER = Logger.getLogger(AdressServiceImpl.class);
	private static AdressServiceImpl adressServiceImpl;

	private AdressServiceImpl() {

		try {
			adressDAO = new AdressDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {

			LOGGER.error(e);
		}

	}

	public static AdressService getAdressService() {
		if (adressServiceImpl == null) {
			adressServiceImpl = new AdressServiceImpl();
		}

		return adressServiceImpl;

	}

	@Override
	public Adress create(Adress t) {

		return adressDAO.create(t);
	}

	@Override
	public Adress read(Integer id) {

		return adressDAO.read(id);
	}

	@Override
	public Adress update(Adress t) {

		return adressDAO.update(t);
	}

	@Override
	public void delete(Integer id) {
		adressDAO.delete(id);

	}

	@Override
	public List<Adress> readAll() {

		return adressDAO.readAll();
	}

}
