package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.AdressDAO;
import ua.lviv.lgs.domain.Adress;
import ua.lviv.lgs.utils.ConnectionUtils;

public class AdressDaoImpl implements AdressDAO {

	private static String READ_ALL = "select * from adress";
	private static String CREATE = "insert into adress(`index`, `country`, `region`,`district`,`city`, `street`, `building`,`flat`) values (?,?,?,?,?,?,?,?)";
	private static String READ_BY_ID = "select * from adress where id =?";
	private static String UPDATE_BY_ID = "update adress set index=?, country=?, region = ?, district=?, city=?, street=?, building=?, flat=? where id = ?";
	private static String DELETE_BY_ID = "delete from adress where id=?";
	
	private static Logger LOGGER = Logger.getLogger(AdressDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;

	public AdressDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();

	}

	@Override
	public Adress create(Adress adress) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, java.sql.Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, adress.getIndex());
			preparedStatement.setString(2, adress.getCountry());
			preparedStatement.setString(3, adress.getRegion());
			preparedStatement.setString(4, adress.getDistrict());
			preparedStatement.setString(5, adress.getSity());
			preparedStatement.setString(6, adress.getStreet());
			preparedStatement.setInt(7, adress.getBuilding());
			preparedStatement.setInt(8, adress.getFlat());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			adress.setId(rs.getInt(1));

		} catch (SQLException e) {

			LOGGER.error(e);
		}

		return adress;
	}

	@Override
	public Adress read(Integer id) {
		Adress adress = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);

			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer adressId = result.getInt("id");
			Integer index = result.getInt("index");
			String country = result.getString("country");
			String region = result.getString("region");
			String district = result.getString("district");
			String city = result.getString("city");
			String street = result.getString("street");
			Integer building = result.getInt("building");
			Integer flat = result.getInt("flat");

			adress = new Adress(adressId, index, country, region, district, city,street, building, flat);

		} catch (SQLException e) {

			LOGGER.error(e);
		}

		return adress;
	}

	@Override
	public Adress update(Adress adress) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, adress.getIndex());
			preparedStatement.setString(2, adress.getCountry());
			preparedStatement.setString(3, adress.getRegion());
			preparedStatement.setString(4, adress.getDistrict());
			preparedStatement.setString(5, adress.getSity());
			preparedStatement.setString(6, adress.getStreet());
			preparedStatement.setInt(7, adress.getBuilding());
			preparedStatement.setInt(8, adress.getFlat());
			preparedStatement.setInt(9, adress.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		}
		return adress;

	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			LOGGER.error(e);
		}
	}

	@Override
	public List<Adress> readAll() {
		List<Adress> adressRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer adressId = result.getInt("id");
				Integer index = result.getInt("index");
				String country = result.getString("country");
				String region = result.getString("region");
				String district = result.getString("district");
				String city = result.getString("city");
				String street = result.getString("street");
				Integer building = result.getInt("building");
				Integer flat = result.getInt("flat");

				adressRecords.add(new Adress(adressId, index, country, region, district, city, street, building, flat));
			}
		} catch (SQLException e) {

			LOGGER.error(e);
		}

		return adressRecords;
	}

}
