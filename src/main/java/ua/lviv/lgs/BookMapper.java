package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
	
	public static Book map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		String description = result.getString("description");
		int price = result.getInt("price");
		String isbn = result.getString("isbn");
		int genre_id = result.getInt("genre_id");
		
		
		return new Book(id, name, description,price,isbn,genre_id );

}
}