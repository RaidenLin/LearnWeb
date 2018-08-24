package com.Raiblue.util;
import java.sql.*;
public class DBConnection {
	private Connection connection;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
