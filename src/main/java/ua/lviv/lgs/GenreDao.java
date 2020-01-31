package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
	
	private static String READ_ALL = "select * from genre";
	private static String CREATE = "insert into genre(`name`) values (?)";
	private static String READ_BY_ID = "select * from genre where id =?";
	private static String UPDATE_BY_ID = "update genre set name=? where id = ?";
	private static String DELETE_BY_ID = "delete from genre where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public GenreDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Genre genre) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		
		preparedStatement.setString(1, genre.getName());
		
		preparedStatement.executeUpdate();
	}
	
	public Genre read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return GenreMapper.map(result);
	}
	
	public void update(Genre genre) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, genre.getName());
		preparedStatement.setInt(2, genre.getId());
		
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Genre> readAll() throws SQLException {
		List<Genre> genre = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			genre.add(GenreMapper.map(result));
		}
		return genre;
	}

}
