package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "11111111";
	private  static String URL = "jdbc:mysql://localhost/library1";	
		
	public static Connection  openConnection() throws InstantiationException, IllegalAccessException,  SQLException, ClassNotFoundException {
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}	
}