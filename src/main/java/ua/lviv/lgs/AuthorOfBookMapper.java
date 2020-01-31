package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorOfBookMapper {
	
	public static AuthorOfBook map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String first_name = result.getString("first_name");
		String last_name = result.getString("last_name");
		String email = result.getString("email");
		String birthday = result.getString("birthday");
		
		
		return new AuthorOfBook(id, first_name, last_name,email,birthday );
	}

}
