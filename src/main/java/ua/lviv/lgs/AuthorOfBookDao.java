package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorOfBookDao {
	
	private static String READ_ALL = "select * from author";
	private static String CREATE = "insert into author(`first_name`, `last_name`,`email`,`birthday`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from author where id =?";
	private static String UPDATE_BY_ID = "update author set first_name=?, last_name = ? ,email = ?,birthday = ? where id = ?";
	private static String DELETE_BY_ID = "delete from author where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public AuthorOfBookDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(AuthorOfBook authorOfBook) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		
		preparedStatement.setString(1, authorOfBook.getFirst_name());
		preparedStatement.setString(2, authorOfBook.getLast_name());
		preparedStatement.setString(3, authorOfBook.getEmail());
		preparedStatement.setString(4, authorOfBook.getBirthday());
		preparedStatement.executeUpdate();
	}
	
	public AuthorOfBook read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AuthorOfBookMapper.map(result);
	}
	
	public void update(AuthorOfBook authorOfBook) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, authorOfBook.getFirst_name());
		preparedStatement.setString(2, authorOfBook.getLast_name());
		preparedStatement.setString(3, authorOfBook.getEmail());
		preparedStatement.setString(4, authorOfBook.getBirthday());
		preparedStatement.setInt(5, authorOfBook.getId());
		
		preparedStatement.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<AuthorOfBook> readAll() throws SQLException {
		List<AuthorOfBook> authorOfBook = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			authorOfBook.add(AuthorOfBookMapper.map(result));
		}
		return authorOfBook;
	}

}





















