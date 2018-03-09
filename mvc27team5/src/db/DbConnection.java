package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	/**
	 * 
	 * @return connection
	 * @throws ClassNotFoundException
	 */
	public static Connection dbConn() throws ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/mvc?" +
				"useUnicode=true&characterEncoding=utf-8";
		String dbUser = "root";
		String dbPass = "java0000";
		try {
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}