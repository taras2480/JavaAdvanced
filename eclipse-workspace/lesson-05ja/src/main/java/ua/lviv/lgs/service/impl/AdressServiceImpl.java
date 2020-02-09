package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.dao.AdressDAO;
import ua.lviv.lgs.dao.impl.AdressDaoImpl;
import ua.lviv.lgs.domain.Adress;
import ua.lviv.lgs.service.AdressService;

public class AdressServiceImpl implements AdressService{
	
	private AdressDAO adressDAO;
	
	public AdressServiceImpl() {

		
		try {
			adressDAO = new AdressDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	

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
